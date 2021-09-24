package com.t4er.member.application;

import com.t4er.member.domain.Member;
import com.t4er.member.dto.request.MemberRegisterRequest;
import com.t4er.member.exception.AlreadyRegisterEmailException;
import com.t4er.member.exception.AlreadyUseNickException;
import com.t4er.member.exception.NotFoundEmailException;
import com.t4er.member.exception.NotMatchPasswordException;
import com.t4er.member.infrastructure.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public Member registerMember(MemberRegisterRequest memberDto) {
        if (memberRepository.countByEmail(memberDto.getEmail()) != 0) {
            throw new AlreadyRegisterEmailException();
        }

        memberDto.setPassword(passwordEncoder.encode(memberDto.getPassword()));
        return memberRepository.save(memberDto.toEntity());
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

    public Member findByEmail(String email) {
        return memberRepository.findByEmail(email)
                .orElseThrow(NotFoundEmailException::new);
    }
}
