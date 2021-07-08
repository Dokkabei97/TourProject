package com.t4er.service.member;

import com.t4er.domain.member.MemberRepository;
import com.t4er.dto.member.MemberJoinDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public Long join (MemberJoinDto joinDto) {
        return memberRepository.save(joinDto.toEntity()).getId();
    }
}
