package com.prod_ready_feature.demo.controller;

import com.prod_ready_feature.demo.dtos.PostDto;
import com.prod_ready_feature.demo.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    @GetMapping
    public List<PostDto> getPosts() {
        return postService.getAllPosts();
    }

    @PostMapping
    public PostDto savePost(@RequestBody PostDto inputDto) {
        return postService.createNewPost(inputDto);
    }

    @GetMapping("/{id}")
    public PostDto getPostById(@PathVariable Long id) {
        return postService.getPostById(id);
    }

    @PutMapping("/{id}")
    public PostDto updatePost(@PathVariable Long id, @RequestBody PostDto inputDto) {
        return postService.updatePost(id, inputDto);
    }

}
