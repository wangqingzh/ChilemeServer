package com.wangqing.chilemeserver.exception;

public class ParameterNullException extends RuntimeException{
    public ParameterNullException(){
        super("参数为空");
    }
}
