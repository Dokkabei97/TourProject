package com.t4er.member.domain;

import com.t4er.common.entity.AbstractEntity;
import com.t4er.common.exception.InvalidParamException;
import com.t4er.point.domain.Point;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "members")
public class Member extends AbstractEntity implements UserDetails {

    @Id @GeneratedValue
    @Column(name = "members_id")
    private Long id;

    @Column(unique = true, updatable = false)
    private String email;
    private boolean verifyEmail;
    private String password;

    @Column(unique = true)
    private String nick;
    private String profileImage;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "member")
    private Point point;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return verifyEmail;
    }

    @Override
    public boolean isAccountNonLocked() {
        return verifyEmail;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return verifyEmail;
    }

    @Override
    public boolean isEnabled() {
        return verifyEmail;
    }

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
        this.verifyEmail = true;
    }
}
