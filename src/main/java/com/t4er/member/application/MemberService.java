package com.t4er.member.application;

import com.t4er.member.domain.Member;
import com.t4er.member.exception.AlreadyRegisterEmailException;
import com.t4er.member.exception.AlreadyUseNickException;
import com.t4er.member.exception.NotFoundEmailException;
import com.t4er.member.exception.NotMatchPasswordException;
import com.t4er.member.infrastructure.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public void registerMember(String email, String password) {
        memberRepository.findByEmail(email)
                .orElseThrow(AlreadyRegisterEmailException::new);

        Member member = Member.builder()
                .email(email)
                .password(password)
                .build();

        memberRepository.save(member);
    }

    @Transactional
    public void updateMemberPassword(String password) {
        Member member = memberRepository.findByPassword(password)
                .orElseThrow(NotMatchPasswordException::new);

        member.updateMemberPassword(password);
    }

    @Transactional
    public void resetMemberPassword(String email, String password) {
        Member member = memberRepository.findByEmail(email)
                .orElseThrow(NotFoundEmailException::new);

        member.updateMemberPassword(password);
    }

    @Transactional
    public void updateMemberProfile(String nick, String profileImage) {
        Member member = memberRepository.findByNick(nick)
                .orElseThrow(AlreadyUseNickException::new);

        member.updateMemberProfile(nick, profileImage);
    }
}
