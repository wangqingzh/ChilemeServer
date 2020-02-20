package com.wangqing.chilemeserver.service;

import com.wangqing.chilemeserver.object.dbo.Post;
import com.wangqing.chilemeserver.object.dto.PostDto;
import com.wangqing.chilemeserver.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    @Autowired
    PostRepository postRepository;

    public Integer addPost(PostDto postDto){
        Post post = new Post();
        post.setHeadLine(postDto.getHeadLine());
        post.setContent(postDto.getContent());
        post.setPartitionId(postDto.getPartitionId());
        post.setRecommendScore(postDto.getRecommendScore());
        post.setPostUserId(postDto.getPostUserId());

        return postRepository.saveAndFlush(post).getPostId();
    }
}
