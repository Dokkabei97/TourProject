package com.t4er.domain.post;

import com.t4er.domain.BaseEntity;
import com.t4er.domain.member.Member;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
public class Post extends BaseEntity {

    @Id @GeneratedValue
    @Column(name = "post_id")
    private Long id;
    private String title; // 제목
    @Column(length = 500)
    private String content; // 내용
    private LocalDateTime date; // 작성일
    private Long inquiry; // 조회수

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

}
