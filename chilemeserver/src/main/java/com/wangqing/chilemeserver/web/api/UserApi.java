package com.wangqing.chilemeserver.web.api;

import com.wangqing.chilemeserver.object.dto.SignUpDto;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 用户web接口 登录 注册 修改密码 找回密码
 */
@RestController
//@RequestMapping("/api/v1/user")
@RequestMapping("/test")
public class UserApi {


    @PostMapping("/")
    public HttpEntity<?> createUser(@RequestBody SignUpDto signUpDto){
        // springboot 检查到请求body为空 则返回错误信息
        System.out.println(signUpDto.toString());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
}
