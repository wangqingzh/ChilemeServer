package com.wangqing.chilemeserver.web.api;

import com.wangqing.chilemeserver.object.ao.CommonResult;
import com.wangqing.chilemeserver.object.dto.PostDto;
import com.wangqing.chilemeserver.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/post")
public class PostApi {
    @Autowired
    PostService postService;
    @PostMapping
    public HttpEntity<?> addPost(@RequestBody PostDto postDto){
        Integer postId = postService.addPost(postDto); // 返回postId 用于上传图片

        return new ResponseEntity<>(CommonResult.success(postId), HttpStatus.OK);
    }
}
