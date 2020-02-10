package com.wangqing.chilemeserver.web.handle;


import com.wangqing.chilemeserver.exception.ParameterNullException;
import com.wangqing.chilemeserver.object.ao.ApiErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * 对异常拦截选哪个拦截然后封装到响应体
 */
@RestControllerAdvice(basePackages = "com.wangqing.chilemeserver.web.api")
public class ApiExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(ParameterNullException.class)
    public HttpEntity<?> ParameterNullExceptionHandle(ParameterNullException exception){
        ApiErrorResponse response = new ApiErrorResponse.ApiErrorResponseBuilder()
                .withStatus(HttpStatus.BAD_REQUEST.value())
                .withError(HttpStatus.BAD_REQUEST.toString())
                .withMessage(exception.getLocalizedMessage())
                .withTrace(exception.getMessage()).build();
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
