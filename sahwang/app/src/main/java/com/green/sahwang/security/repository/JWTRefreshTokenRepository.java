package com.green.sahwang.security.repository;

import com.green.sahwang.security.entity.JWTRefreshToken;
import org.springframework.data.repository.CrudRepository;

public interface JWTRefreshTokenRepository extends CrudRepository<JWTRefreshToken, String> {

    JWTRefreshToken findByMemberId(Long memberId);

}
