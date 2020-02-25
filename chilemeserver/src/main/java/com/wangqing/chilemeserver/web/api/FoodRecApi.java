package com.wangqing.chilemeserver.web.api;

import com.wangqing.chilemeserver.object.ao.CommonResult;
import com.wangqing.chilemeserver.object.dto.FoodRecPostDto;
import com.wangqing.chilemeserver.service.FoodRecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/food_rec")
public class FoodRecApi {
    @Autowired
    FoodRecService foodRecService;
    @PostMapping("/post")
    public HttpEntity<?> addPost(@RequestBody FoodRecPostDto postDto){
        Integer postId = foodRecService.addPost(postDto); // 返回postId 用于上传图片
        return new ResponseEntity<>(CommonResult.success(postId), HttpStatus.OK);
    }
}
