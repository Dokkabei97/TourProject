package com.t4er.domain.post;

import com.t4er.service.post.PostService;
import com.t4er.web.post.dto.PostSaveDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class PostRepositoryTest {

    @Autowired PostRepository postRepository;

}