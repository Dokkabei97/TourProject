package com.t4er.member.domain;

import com.t4er.common.entity.AbstractEntity;
import com.t4er.common.exception.InvalidParamException;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

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
    private boolean verifyEmail;
    private String password;

    private String nick;
    private String profileImage;

    @Builder
    public Member(String email, String password) {
        if (StringUtils.isBlank(email)) throw new InvalidParamException("Member.email");
        if (StringUtils.isBlank(password)) throw new InvalidParamException("Member.password");

        this.email = email;
        this.password = password;
        this.nick = email;
        this.profileImage = null;
        this.verifyEmail = false;
    }

    public void updateMemberPassword(String password) {
        this.password = password;
    }

    public void updateMemberProfile(String nick, String profileImage) {
        this.nick = nick;
        this.profileImage = profileImage;
    }

    public void verifyEmail() {
        // TODO: 2021-09-19
    }
}
