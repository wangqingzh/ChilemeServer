package com.wangqing.chilemeserver.web.api;

import com.wangqing.chilemeserver.object.ao.ApiErrorResponse;
import com.wangqing.chilemeserver.object.ao.ErrorCode;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户web接口
 */
@RestController
//@RequestMapping("/api/v1/user")
public class UserApi {
    @GetMapping("/test")
    public HttpEntity<?> test(){
        ApiErrorResponse response = new ApiErrorResponse.ApiErrorResponseBuilder()
                .withStatus(HttpStatus.ACCEPTED)
                .withError_code(ErrorCode.USER_LOGIN_ERROR.getCode())
                .withMessage("")
                .withDetail("")
                .build();
        return new ResponseEntity<>(response, response.getStatus());
    }
    
}
