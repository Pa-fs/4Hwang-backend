package com.green.sahwang.pendingsale.repository;

import com.green.sahwang.pendingsale.entity.PendingSale;
import com.green.sahwang.pendingsale.entity.UserSaleImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserSaleImageRepository extends JpaRepository<UserSaleImage, Long> {

    List<UserSaleImage> findAllByPendingSale(PendingSale pendingSale);

}
