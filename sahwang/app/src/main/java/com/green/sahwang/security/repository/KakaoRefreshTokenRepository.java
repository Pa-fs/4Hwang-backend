package com.green.sahwang.security.repository;

import com.green.sahwang.security.entity.KakaoRefreshToken;
import org.springframework.data.repository.CrudRepository;

public interface KakaoRefreshTokenRepository extends CrudRepository<KakaoRefreshToken, String> {

    KakaoRefreshToken findByMemberId(Long memberId);

}
