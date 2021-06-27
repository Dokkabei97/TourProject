package com.t4er.domain.member;

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

    @Test
    void join() throws Exception {
        // given
        Member member = new Member("testAccount1", "test123", "test", "test@test.com", Role.USER);

        // when
        memberRepository.save(member);

        // then
        assertThat(member.getUserId()).isEqualTo("testAccount1");
        assertThat(member.getPassword()).isEqualTo("test123");
        assertThat(member.getNick()).isEqualTo("test");
        assertThat(member.getEmail()).isEqualTo("test@test.com");

        // 실패 검증 코드 추가해야함
    }

}