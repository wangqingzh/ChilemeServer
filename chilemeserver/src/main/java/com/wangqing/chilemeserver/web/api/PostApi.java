package com.wangqing.chilemeserver.web.api;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/post")
public class PostApi {
    @PostMapping
    public HttpEntity<?> addPost(){
        return new ResponseEntity<>();
    }
}
