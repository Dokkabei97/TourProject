package com.t4er.member.domain;

import com.google.common.collect.Lists;
import com.t4er.common.entity.AbstractEntity;
import com.t4er.common.exception.InvalidParamException;
import com.t4er.common.util.TokenGenerator;
import com.t4er.order.domain.Order;
import com.t4er.point.domain.Point;
import com.t4er.post.domain.Post;
import com.t4er.review.domain.Review;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "members")
public class Member extends AbstractEntity implements UserDetails {

    private final static String MEMBER_PREFIX = "mem_";

    @Id
    @GeneratedValue
    @Column(name = "members_id")
    private Long id;

    @Column(unique = true, updatable = false)
    private String email;
    private Boolean verifyEmail;
    private String password;

    @Column(updatable = false)
    private String memberToken;
    @Column(unique = true)
    private String nick;
    private String profileImage;
    private String authority;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "member")
    private Point point;

    @OneToMany(mappedBy = "member")
    private List<Order> orderList = Lists.newArrayList();

    @OneToMany(mappedBy = "author")
    private List<Post> postList = Lists.newArrayList();

    @OneToMany(mappedBy = "author")
    private List<Review> reviewList = Lists.newArrayList();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton((GrantedAuthority) () -> authority);
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
    public Member(String email, String password, String authority) {
        if (StringUtils.isBlank(email)) throw new InvalidParamException("Member.email");
        if (StringUtils.isBlank(password)) throw new InvalidParamException("Member.password");

        this.memberToken = TokenGenerator.randomCharacterWithPrefix(MEMBER_PREFIX);
        this.email = email;
        this.password = password;
        this.nick = email;
        this.profileImage = null;
        this.verifyEmail = false;
        this.authority = authority;
        this.point = new Point(1000L);
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
