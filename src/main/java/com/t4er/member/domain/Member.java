package com.t4er.member.domain;

import com.t4er.common.entity.BaseEntity;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Member extends BaseEntity {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;
    private String userId; // 아이디
    private String pwd; // 비밀번호
    private String nick; // 닉네임
    private String email; // 이메일
    @Enumerated(EnumType.STRING)
    private Role role; // 권한

}
