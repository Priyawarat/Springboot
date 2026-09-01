package com.prod_ready_feature.demo.service;

import com.prod_ready_feature.demo.dtos.PostDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {

    List<PostDto> getAllPosts();

    PostDto createNewPost(PostDto inputPost);

    PostDto getPostById(Long id);

    PostDto updatePost(Long id, PostDto inputDto);
}
