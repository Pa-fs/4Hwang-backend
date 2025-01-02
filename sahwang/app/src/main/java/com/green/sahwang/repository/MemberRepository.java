package com.green.sahwang.repository;

import com.green.sahwang.entity.Member;
import com.green.sahwang.entity.Review;
import com.green.sahwang.entity.enumtype.MemberRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

//    Optional<Member> findByEmail(String email);
    Member findByEmail(String email);

    List<Member> findAllByEmail(String email);

    Page<Member> findAllByRole(MemberRole role, Pageable pageable);

    Page<Member> findAll(Pageable pageable);

    @Query(value = """
            SELECT m.member_id, m.nick_name, m.email, m.join_date
            FROM member m
            WHERE DATE(m.join_date) = CURRENT_DATE
            """,nativeQuery = true)
    List<Object[]> getJoinMembers();

    @Query(value = """
            SELECT COUNT(*)
            FROM member m
            WHERE DATE(m.join_date) = CURRENT_DATE;
            """,nativeQuery = true)
    int joinMembers();

    @Query(value = """
            SELECT m.member_id, m.nick_name, m.email, m.last_login_date
            FROM member m
            WHERE DATE(m.last_login_date) = CURRENT_DATE;
            """,nativeQuery = true)
    List<Object[]> getLoginMembers();

    @Query(value = """
            SELECT COUNT(*)
            FROM member m
            WHERE DATE(m.last_login_date) = CURRENT_DATE;
            """,nativeQuery = true)
    int logInMembers();

}
