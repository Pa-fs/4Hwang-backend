package com.green.sahwang.security.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;
import org.springframework.data.redis.core.index.Indexed;

@RedisHash(value = "jwtRefreshToken")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class JWTRefreshToken {

    @Id
    private String jwtRefreshToken;

    @Indexed
    private Long memberId;

    @TimeToLive
    private long ttl;

}
