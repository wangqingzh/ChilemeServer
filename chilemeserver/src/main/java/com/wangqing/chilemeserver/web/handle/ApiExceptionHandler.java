package com.wangqing.chilemeserver.web.handle;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * 对异常拦截选哪个拦截然后封装到响应体
 */
@RestControllerAdvice(basePackages = "com.wangqing.chilemeserver.web.api")
public class ApiExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    //@ExceptionHandler()
}
