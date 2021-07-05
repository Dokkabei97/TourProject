package com.t4er.domain.member;

import com.t4er.service.member.MemberService;
import com.t4er.web.member.dto.MemberJoinDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberRepositoryTest {

    @Autowired MemberRepository memberRepository;
    @Autowired MemberService memberService;

    @Test
    void join() throws Exception {
        // given
        Member member = new Member("testAccount1", "test123", "test", "test@test.com", Role.USER);
        // when
        Member saveMember = memberRepository.save(member);

        // then
        assertThat(saveMember.getUserId()).isEqualTo("testAccount1");

        // 실패 검증 코드 추가해야함
    }

}