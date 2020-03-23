package com.wangqing.chilemeserver.web.api;

import com.wangqing.chilemeserver.object.ao.CommonResult;
import com.wangqing.chilemeserver.service.DynamicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/dynamic")
@RestController
public class DynamicApi {
    @Autowired
    DynamicService dynamicService;


    @GetMapping("/{userId}")
    public HttpEntity<?> getDynamicList(@PathVariable("userId") Integer userId){
        return new ResponseEntity<>(CommonResult.success(dynamicService.getDynamicList(userId)), HttpStatus.OK);
    }
}
