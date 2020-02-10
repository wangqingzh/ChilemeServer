package com.wangqing.chilemeserver.exception;

public class UserExistedException extends RuntimeException {
    public UserExistedException(){
        super("用户已存在！");
    }
}
