package com.wangqing.chilemeserver.web.api;

import com.wangqing.chilemeserver.object.ao.CommonResult;
import com.wangqing.chilemeserver.service.MyFavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 收藏接口
 */
@RestController
@RequestMapping("/api/v1/favorite")
public class FavoriteApi {
    @Autowired
    MyFavoriteService myFavoriteService;
    @PostMapping
    public HttpEntity<?> giveAFavorite(@RequestParam("postId") Integer postId, @RequestParam("userId") Integer userId){
        myFavoriteService.giveAFavorite(postId, userId);
        return new ResponseEntity<>(CommonResult.success(), HttpStatus.OK);
    }
}
