package com.t4er.domain.post;

import com.t4er.domain.BaseEntity;
import com.t4er.domain.member.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
public class Post extends BaseEntity {

    @Id @GeneratedValue
    @Column(name = "post_id")
    private Long id;
    @Column(nullable = false)
    private String title; // 제목
    @Column(length = 500, nullable = false)
    private String content; // 내용
    private LocalDateTime date; // 작성일
    private Long inquiry; // 조회수

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Builder
    public Post(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
