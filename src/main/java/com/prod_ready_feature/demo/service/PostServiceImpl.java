package com.prod_ready_feature.demo.service;

import com.prod_ready_feature.demo.dtos.PostDto;
import com.prod_ready_feature.demo.entities.PostEntity;
import com.prod_ready_feature.demo.exceptions.ResourceNotFoundException;
import com.prod_ready_feature.demo.repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{

    private final PostRepository postRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<PostDto> getAllPosts() {

        List<PostDto> posts = postRepository.findAll().stream()
                .map(postEntity -> modelMapper.map(postEntity, PostDto.class))
                .toList();

        return posts;
    }

    @Override
    public PostDto createNewPost(PostDto inputPost) {

        System.out.println("Input Post: " + inputPost.toString());
        PostEntity postEntity = modelMapper.map(inputPost, PostEntity.class);
        PostEntity savedPostEntity = postRepository.save(postEntity);
        PostDto savedPostDto = modelMapper.map(savedPostEntity, PostDto.class);
        return savedPostDto;
    }

    @Override
    public PostDto getPostById(Long id) {

        PostEntity postEntity = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post not found with id: " + id));

        return modelMapper.map(postEntity, PostDto.class);
    }

    @Override
    public PostDto updatePost(Long id, PostDto inputDto) {

        PostEntity postEntity = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post not found with id: " + id));

        modelMapper.map(inputDto, postEntity);
        PostEntity updatedPostEntity = postRepository.save(postEntity);
        return modelMapper.map(updatedPostEntity, PostDto.class);
    }

}
