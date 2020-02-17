package com.wangqing.chilemeserver.security;

import com.wangqing.chilemeserver.object.ao.CommonResult;
import com.wangqing.chilemeserver.object.ao.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.provider.endpoint.FrameworkEndpoint;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 退出登录
 */
@FrameworkEndpoint
public class RevokeTokenEndpoint {
    @Autowired
    @Qualifier("consumerTokenServices")
    ConsumerTokenServices consumerTokenServices;

    @DeleteMapping("/oauth/token")
    @ResponseBody
    public HttpEntity<?> revokeToken(String access_token){
        if (consumerTokenServices.revokeToken(access_token)){
            CommonResult commonResult = CommonResult.success(ResultCode.LOG_OUT_SUCCESS);
            return new ResponseEntity<>(commonResult, HttpStatus.OK);
        }else {
            CommonResult commonResult = CommonResult.error(ResultCode.LOG_OUT_ERROR);
            return new ResponseEntity<>(commonResult, HttpStatus.OK);
        }
    }
}
