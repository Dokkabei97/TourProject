package com.t4er.domain.member;

import com.t4er.domain.BaseEntity;
import com.t4er.domain.post.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Member extends BaseEntity {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;
    @Column(length = 20, nullable = false)
    private String userId; // 아이디
    @Column(length = 100, nullable = false)
    private String password; // 비밀번호
    @Column(length = 50, nullable = false)
    private String nick; // 닉네임
    @Column(length = 100, nullable = false)
    private String email; // 이메일
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role; // 권한

    @OneToMany(mappedBy = "member")
    private List<Post> post = new ArrayList<>();

    public Member(String userId, String password, String nick, String email, Role role) {
        this.userId = userId;
        this.password = password;
        this.nick = nick;
        this.email = email;
        this.role = role;
    }

    public Member(Role role) {
        this.role = role;
    }

}
