package com.t4er.domain.member;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByUserId(String userId);
}
