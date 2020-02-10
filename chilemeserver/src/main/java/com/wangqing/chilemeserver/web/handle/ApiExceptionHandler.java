package com.wangqing.chilemeserver.web.handle;


import com.wangqing.chilemeserver.exception.ParameterNullException;
import com.wangqing.chilemeserver.exception.UserExistedException;
import com.wangqing.chilemeserver.object.ao.CommonResult;
import com.wangqing.chilemeserver.object.ao.ResultCode;
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

    /**
     * 参数为空异常处理器
     * @param exception
     * @return
     */
    @ExceptionHandler({ParameterNullException.class})
    public HttpEntity<?> ParameterNullExceptionHandle(ParameterNullException exception) {

        return new ResponseEntity<>(CommonResult.error(ResultCode.PARAM_IS_BLANK), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * 用户已存在异常处理器
     * @param exception
     * @return
     */
    @ExceptionHandler({UserExistedException.class})
    public HttpEntity<?> userExistedExceptionHandle(UserExistedException exception){

        return new ResponseEntity<>(CommonResult.error(ResultCode.USER_HAS_EXITED), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
