package com.t4er.dto.admin;

import com.t4er.domain.member.Member;
import com.t4er.domain.member.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AdminCheckDto {

    private Role role;

    public Member checkAdmin() {
        return Member.builder()
                .role(role)
                .build();
    }
}
