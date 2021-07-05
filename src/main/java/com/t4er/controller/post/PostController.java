package com.t4er.controller.post;

import com.t4er.domain.post.Post;
import com.t4er.service.post.PostService;
import com.t4er.dto.post.PostSaveDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    @GetMapping("/list")
    public String postList(Model model) {
        return "post/list";
    }

    @GetMapping("/write")
    public String writePost(Model model) {
        model.addAttribute("post", new Post());
        return "post/write";
    }

    @PostMapping("/write")
    public String savePost(@ModelAttribute("post") PostSaveDto saveDto) {
        postService.save(saveDto);
        return "redirect:/post/list";
    }

}
