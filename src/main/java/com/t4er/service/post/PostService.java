package com.t4er.service.post;

import com.t4er.domain.post.PostRepository;
import com.t4er.dto.post.PostSaveDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    public Long save(PostSaveDto saveDto) {
        return postRepository.save(saveDto.toEntity()).getId();
    }
}
