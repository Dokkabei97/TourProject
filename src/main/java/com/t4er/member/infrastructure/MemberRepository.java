package com.t4er.member.infrastructure;

import com.t4er.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByEmail(String email);

    Optional<Member> findByNick(String nick);

    Optional<Member> findByPassword(String password);

    Optional<Member> findByMemberToken(String memberToken);

    Long countByEmail(String email);
}
