package com.green.sahwang.entity;

import com.green.sahwang.entity.enumtype.MemberRole;
import com.green.sahwang.entity.enumtype.SnsType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private MemberRole role;

    private String phoneNum;

    private String email;

    private String address;

    private SnsType snsType;

    private String nickName;

    private Boolean adReceived;

    private String account;

    private Boolean isDeleted;

    private LocalDate joinDate;

    private LocalDate withdrawDate;

    // 이건 어떻게 해야되???
//    private

}
