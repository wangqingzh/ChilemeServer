package com.wangqing.chilemeserver.object.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class SignUpDto {
    /* 登录类型 默认phone*/
    private String identityType = "phone";
    /* username */
    private String identifier;
    /* password */
    private String credential;
    /* 密保问题 */
    private String securityQuestion;
    /* 密保答案 */
    private String securityAnswer;
}
