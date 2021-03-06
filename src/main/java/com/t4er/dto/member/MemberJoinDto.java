package com.t4er.dto.member;

import com.t4er.domain.member.Member;
import com.t4er.domain.member.Role;
import lombok.*;

@Getter @Setter
@NoArgsConstructor
public class MemberJoinDto {

    private String userId;
    private String password;
    private String nick;
    private String email;
    private Role role;

    public MemberJoinDto(String userId, String password, String nick, String email, Role role) {
        this.userId = userId;
        this.password = password;
        this.nick = nick;
        this.email = email;
        this.role = role;
    }

    public Member toEntity() {
        return Member.builder()
                .userId(userId)
                .password(password)
                .nick(nick)
                .email(email)
                .role(role)
                .build();
    }
}
