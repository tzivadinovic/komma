package com.tzivadinovic.komma.controller;

import com.tzivadinovic.komma.entity.Comment;
import com.tzivadinovic.komma.entity.Post;
import com.tzivadinovic.komma.entity.User;
import com.tzivadinovic.komma.service.CommentService;
import com.tzivadinovic.komma.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;
    private final PostService postService;

    @PostMapping("/save-comment/posts/{postId}")
    public String saveComment(Model model,
                              Comment comment,
                              @AuthenticationPrincipal User user,
                              @PathVariable Integer postId) {
        Post post = postService.findById(postId);
        comment.setPost(post);
        comment.setUser(user);
        model.addAttribute("comment", commentService.save(comment));
        return "redirect:/post/" + postId;
    }

}
