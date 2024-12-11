package com.green.sahwang.security.repository;

import com.green.sahwang.security.entity.KakaoAccessToken;
import org.springframework.data.repository.CrudRepository;

public interface KakaoAccessTokenRepository extends CrudRepository<KakaoAccessToken, String> {

    KakaoAccessToken findByMemberId(Long memberId);

}
