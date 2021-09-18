package com.t4er.member.domain;

import com.t4er.common.entity.AbstractEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "members")
public class Member extends AbstractEntity {

    @Id @GeneratedValue
    private Long id;

    private String email;

    private String password;

    private String nick;

    private String profileImage;

    @Builder
    public Member(String email, String password, String nick, String profileImage) {
        this.email = email;
        this.password = password;
        this.nick = nick;
        this.profileImage = profileImage;
    }

    public void updateMemberProfile(String nick, String profileImage) {
        this.nick = nick;
        this.profileImage = profileImage;
    }
}
