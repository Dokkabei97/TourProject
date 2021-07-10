package com.t4er.domain.post;

import com.t4er.domain.BaseEntity;
import com.t4er.domain.member.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

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

    public static Post postWrite(Member member) {
        Post post = new Post();
        post.title = post.getTitle();
        post.content = post.getContent();
        post.member = member;
        post.date = LocalDateTime.now();
        post.inquiry = 0L;
        return post;
    }

    @Builder
    public Post(String title, String content, LocalDateTime date, Long inquiry, Member member) {
        this.title = title;
        this.content = content;
        this.date = date;
        this.inquiry = inquiry;
        this.member = member;
    }
}
