package com.t4er.controller.post;

import com.t4er.domain.member.Member;
import com.t4er.domain.post.Post;
import com.t4er.service.post.PostService;
import com.t4er.dto.post.PostSaveDto;
import com.t4er.session.SessionConst;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
    public String writePost(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Member saveDto = (Member) session.getAttribute(SessionConst.LOGIN_MEMBER);
        Long memberId = saveDto.getId();

        model.addAttribute("memberId", memberId);
        model.addAttribute("post", new PostSaveDto());
        return "post/write";
    }

    @PostMapping("/write")
    public String savePost(@ModelAttribute("post") PostSaveDto saveDto) {
        postService.save(saveDto);
        return "redirect:/posts/list";
    }

}
