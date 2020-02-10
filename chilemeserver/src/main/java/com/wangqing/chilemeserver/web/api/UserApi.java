package com.wangqing.chilemeserver.web.api;

import com.wangqing.chilemeserver.exception.UserExistedException;
import com.wangqing.chilemeserver.object.ao.CommonResult;
import com.wangqing.chilemeserver.object.dbo.UserDbo;
import com.wangqing.chilemeserver.object.dto.SignUpDto;
import com.wangqing.chilemeserver.repository.UserRepository;
import com.wangqing.chilemeserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * 用户web接口 登录 注册 修改密码 找回密码
 */
@RestController
@RequestMapping("/api/v1/user")
//@RequestMapping("/test")
public class UserApi {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @PostMapping
    public HttpEntity<?> createUser(@RequestBody SignUpDto signUpDto) {
        // springboot 检查到请求body为空 则返回错误信息
        if (!StringUtils.isEmpty(signUpDto.getIdentifier())){
            UserDbo userDbo = userRepository.findUserDboByIdentifier(signUpDto.getIdentifier());
            if (userDbo != null){
                throw new UserExistedException();
            }
        }
        userService.createUser(signUpDto);
        return new ResponseEntity<>(CommonResult.success(), HttpStatus.CREATED);
    }

}
