package com.wangqing.chilemeserver.web.api;

import com.wangqing.chilemeserver.object.ao.CommonResult;
import com.wangqing.chilemeserver.object.dto.LikeReqDto;
import com.wangqing.chilemeserver.service.MyLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 点赞接口
 */
@RestController
@RequestMapping("/api/v1/like")
public class LikeApi {
    @Autowired
    MyLikeService myLikeService;

    /**
     * 点赞、取消点赞
     * @param likeReqDto
     * @return
     */
    @PostMapping
    public HttpEntity<?> giveALike(@RequestBody LikeReqDto likeReqDto){
        myLikeService.giveALike(likeReqDto);
        return new ResponseEntity<>(CommonResult.success(), HttpStatus.OK);
    }
}
