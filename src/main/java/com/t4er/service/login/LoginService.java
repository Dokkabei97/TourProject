package com.t4er.service.login;

import com.t4er.domain.member.Member;
import com.t4er.domain.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final MemberRepository memberRepository;

    public Member login(String userId, String password) {
        return memberRepository.findByUserId(userId)
                .filter(member -> member.getPassword().equals(password))
                .orElse(null);
    }
}
