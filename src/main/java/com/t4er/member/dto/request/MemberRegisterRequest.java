package com.t4er.member.dto.request;

import com.t4er.member.domain.Member;
import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberRegisterRequest {

    @NotBlank(message = "이메일은 필수 항목입니다!")
    private String email;
    @NotBlank(message = "비밀번호는 필수 항목입니다!")
    private String password;

    @Builder
    public MemberRegisterRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Member toEntity() {
        return Member.builder()
                .email(email)
                .password(password)
                .build();
    }
}
