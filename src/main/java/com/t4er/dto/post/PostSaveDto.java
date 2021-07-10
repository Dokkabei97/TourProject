package com.t4er.dto.post;

import com.t4er.domain.member.Member;
import com.t4er.domain.post.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor
public class PostSaveDto {

    private String title;
    private String content;
    private Member member;
    private LocalDateTime date;
    private Long inquiry;

    public Post toEntity() {
        return Post.builder()
                .title(title)
                .content(content)
                .member(member)
                .date(LocalDateTime.now())
                .inquiry(0L)
                .build();
    }
}
