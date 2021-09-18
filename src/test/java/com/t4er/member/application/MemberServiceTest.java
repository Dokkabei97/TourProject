package com.t4er.member.application;

import com.t4er.member.domain.Member;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.BDDAssertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired
    private MemberService memberService;

    @Test
    void 회원가입() throws Exception {
        // given
        String email = "test@test.com";
        String pwd = "1234";
        // when
        Member member = memberService.registerMember(email, pwd);
        // then
        assertThat(member.getId()).isNotNull();
        assertThat(member.getEmail()).isEqualTo("test@test.com");
//        assertThat(member.getPassword()).startsWith("{bcrypt}");
        assertThat(member.getNick()).isEqualTo("test@test.com");
        assertThat(member.getProfileImage()).isNull();
//        then(member.getEmail()).isEqualTo("test@test.com");

    }

    @Test
    void updateMemberPassword() {
    }

    @Test
    void resetMemberPassword() {
    }

    @Test
    void updateMemberProfile() {
    }

    @Test
    void findByEmail() {
    }
}