package com.green.sahwang.repository;

import com.green.sahwang.adminpage.dto.CategoryManageDto;
import com.green.sahwang.brand.entity.Brand;
import com.green.sahwang.dto.response.ProductWithSaleInfoDto;
import com.green.sahwang.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long>, ProductRepositoryCustom {

    Page<Product> findAllProductsByDtype(Pageable pageable, String dtype);

    List<Product> findProductsByBrandAndDtype(Brand brand, Pageable pageable, String dtype);

    @Query(value = "SELECT * FROM product p WHERE p.dtype= :dtype", nativeQuery = true)
    List<Product> findAllByDtype(@Param("dtype") String type);

    @Query(value = """
    SELECT
        p.*,
        GROUP_CONCAT(DISTINCT sg.grade_type ORDER BY sg.grade_type SEPARATOR ', ') AS gradeTypes,
        COUNT(up.used_product_id) AS productCount
    FROM product p
    INNER JOIN pending_sale ps ON p.product_id = ps.product_id
    LEFT JOIN verified_sale vs ON ps.pending_sale_id = vs.pending_sale_id
    LEFT JOIN used_product up ON vs.verified_sale_id = up.verified_sale_id
    JOIN sale_grade sg ON vs.sale_grade_id = sg.sale_grade_id
    WHERE
        (ps.inspection_status = 'SELLING' OR
        (ps.inspection_status = 'SOLD' AND up.sold_out = true))
    GROUP BY p.product_id
    HAVING
        SUM(CASE WHEN ps.inspection_status = 'SELLING' THEN 1 ELSE 0 END) > 0
    ORDER BY productCount DESC
    """, nativeQuery = true)
    List<Product> findRandomProducts();

    List<Product> findAllByName(String productName);

    List<Product> findAllByNameContaining(String search);

    @Query("SELECT p FROM Product p WHERE p.name LIKE CONCAT(:keyword, '%') ORDER BY p.name ASC LIMIT 5")
    List<Product> findByKeyword(@Param("keyword") String keyword);

    List<Product> findAllByBrandId(Long brandId);

    Optional<Product> findByName(String productName);

    @Query(value = """
            SELECT p.product_id, p.main_image, b.`name`, p.`name`, MIN(ps.excepted_selling_price) AS min_price, MAX(ps.excepted_selling_price) AS max_price, p.content, p.size, COUNT(up.used_product_id) AS usedProductCount
            FROM product p
            INNER JOIN brand b ON b.brand_id = p.brand_id
            INNER JOIN pending_sale ps ON ps.product_id = p.product_id
            INNER JOIN verified_sale vs ON vs.pending_sale_id = ps.pending_sale_id
            INNER JOIN used_product up ON up.verified_sale_id = vs.verified_sale_id
            WHERE vs.rejected_sale_id IS NULL
            AND ps.inspection_status = 'SELLING'
            GROUP BY p.product_id
            ORDER BY RAND()
            LIMIT 5
            """, nativeQuery = true)
    List<Object[]> findByRandom();

    @Query(value = """
            SELECT
                p.product_id,
                p.name AS product_name,
                p.size,
                p.dtype,
                b.name AS brand_name,
                COALESCE(SUM(CASE WHEN vs.rejected_sale_id IS NULL AND up.used_product_id IS NOT NULL THEN 1 ELSE 0 END), 0) AS used_product_count,
                pi.filename
            FROM product p
            INNER JOIN brand b ON b.brand_id = p.brand_id
            LEFT JOIN pending_sale ps ON ps.product_id = p.product_id
            LEFT JOIN verified_sale vs ON vs.pending_sale_id = ps.pending_sale_id
            LEFT JOIN used_product up ON up.verified_sale_id = vs.verified_sale_id
            LEFT JOIN (SELECT MIN(filename) AS filename, product_id FROM product_image pi GROUP BY product_id) pi ON pi.product_id = p.product_id
            WHERE ps.inspection_status = 'SELLING' OR ps.product_id IS NULL
            GROUP BY
                p.product_id,
                p.name,
                p.size,
                p.dtype,
                b.name,
                pi.filename
            ORDER BY p.product_id
            LIMIT :limit OFFSET :offset
            """, nativeQuery = true)
    List<Object[]> findProducts(@Param("limit") int limit, @Param("offset") int offset);

    @Query("SELECT COUNT(p) FROM Product p")
    int countTotalProducts();
}
