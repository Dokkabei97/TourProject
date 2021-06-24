package com.t4er.member.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;
    private String userId;
    private String pwd;
    private String nick;
    private String email;
    @Enumerated(EnumType.STRING)
    private Role role;

}
