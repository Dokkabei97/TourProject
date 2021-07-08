package com.t4er.service.post;

import com.t4er.domain.post.PostRepository;
import com.t4er.dto.post.PostSaveDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public Long save(PostSaveDto saveDto) {
        return postRepository.save(saveDto.toEntity()).getId();
    }
}
