package com.t4er.post.domain;

import com.t4er.common.entity.BaseEntity;
import com.t4er.member.domain.Member;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
public class Post extends BaseEntity {

    @Id @GeneratedValue
    @Column(name = "post_id")
    private Long id;
    private String title; // 제목
    private String content; // 내용
    private LocalDateTime date; // 작성일
    private Long inquiry; // 조회수

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

}
