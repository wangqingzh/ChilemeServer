package com.wangqing.chilemeserver.web.api;

import com.wangqing.chilemeserver.object.ao.CommonResult;
import com.wangqing.chilemeserver.object.dto.EvaluatePostDto;
import com.wangqing.chilemeserver.service.CampusEvaluateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/evaluate")
public class EvaluateApi {

    @Autowired
    CampusEvaluateService campusEvaluateService;

    /**
     * 增加一条校园餐饮评价
     *
     * @param evaluate
     * @return postId 用于上传图片
     */
    @PostMapping("/post")
    public HttpEntity<?> addPost(@RequestBody EvaluatePostDto evaluate) {
        Integer postId = campusEvaluateService.addEvaluate(evaluate);
        return new ResponseEntity<>(CommonResult.success(postId), HttpStatus.OK);
    }

    @GetMapping("/browser")
    public HttpEntity<?> getEvaluate(@RequestParam("userId") Integer userId,
                                     @RequestParam("hallId") Integer hallId
    ) {
        return new ResponseEntity<>(CommonResult.success(campusEvaluateService.getEvaluate(userId, hallId)), HttpStatus.OK);
    }
}
