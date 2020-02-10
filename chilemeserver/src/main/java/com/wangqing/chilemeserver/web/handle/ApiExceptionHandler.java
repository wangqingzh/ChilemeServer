package com.wangqing.chilemeserver.web.handle;


import com.wangqing.chilemeserver.exception.ParameterNullException;
import com.wangqing.chilemeserver.object.ao.ApiErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 对异常拦截选哪个拦截然后封装到响应体
 */
@ControllerAdvice
@ResponseBody
public class ApiExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler({ParameterNullException.class})
    public HttpEntity<?> ParameterNullExceptionHandle(ParameterNullException exception) {
        ApiErrorResponse response = new ApiErrorResponse.ApiErrorResponseBuilder()
                .withHttpStatus(HttpStatus.BAD_REQUEST) //利用http返回码做简单信息
                .withMessage(exception.getLocalizedMessage()) // 详细信息
                .build();
        return new ResponseEntity<>(response, response.getHttpStatus());
    }
}
