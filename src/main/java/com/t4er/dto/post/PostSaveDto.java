package com.t4er.dto.post;

import com.t4er.domain.member.Member;
import com.t4er.domain.post.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class PostSaveDto {

    private String title;
    private String content;
    private Member member;

    public PostSaveDto(String title, String content, Member member) {
        this.title = title;
        this.content = content;
        this.member = member;
    }

    public Post toEntity() {
        return Post.builder()
                .title(title)
                .content(content)
                .member(member)
                .build();
    }
}
