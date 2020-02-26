package com.wangqing.chilemeserver.service;

import com.wangqing.chilemeserver.object.dbo.FoodRec;
import com.wangqing.chilemeserver.object.dbo.Post;
import com.wangqing.chilemeserver.object.dto.FoodRecBrowserDto;
import com.wangqing.chilemeserver.object.dto.FoodRecPostDto;
import com.wangqing.chilemeserver.repository.FoodRecMapper;
import com.wangqing.chilemeserver.repository.FoodRecRepository;
import com.wangqing.chilemeserver.repository.PostRepository;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodRecService {
    @Autowired
    PostRepository postRepository;

    @Autowired
    FoodRecRepository foodRecRepository;

    @Autowired
    FoodRecMapper foodRecMapper;


    public Integer addPost(FoodRecPostDto postDto){
        Post post = new Post();
        post.setPostType(1);
        post.setHeadline(postDto.getHeadline());
        post.setUserId(postDto.getPostUserId());

        post = postRepository.saveAndFlush(post);

        foodRecRepository.saveAndFlush(FoodRec.of(post.getPostId(), postDto.getContent(), postDto.getClassifyId(), postDto.getRecommendScore()));

        return post.getPostId();
    }

    /**
     * 根据推荐分类和用户id 取出所有的帖子
     * @param userId
     * @param classifyId
     * @return
     */
    List<FoodRecBrowserDto> foodRecBrowserByClassifyId(Integer userId, Integer classifyId){
        return foodRecMapper.foodRecBrowserByClassifyId(userId, classifyId);
    }



}
