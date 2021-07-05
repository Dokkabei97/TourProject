package com.t4er.web.post.dto;

import com.t4er.domain.post.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class PostSaveDto {

    private String title;
    private String content;

    public PostSaveDto(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Post toEntity() {
        return Post.builder()
                .title(title)
                .content(content)
                .build();
    }
}
