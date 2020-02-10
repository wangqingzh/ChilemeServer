package com.wangqing.chilemeserver.object.dbo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * 用户核心表
 */
@Entity
@Data
@NoArgsConstructor
@Table(name = "user")
@EntityListeners(AuditingEntityListener.class)
public class UserDbo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(columnDefinition = "COMMENT '用户id'")  // 关联 UserDB 表中的id
    private Integer userId;

    //@Column(columnDefinition = "COMMENT '登录类型'") // account phone email wechat qq
    private String identityType = "phone";

    //@Column(columnDefinition = "COMMENT '登录标识'") // username
    private String identifier;

    //@Column(columnDefinition = "COMMENT '登录密码'") // password
    private String credential;

    //@Column(columnDefinition = "COMMENT '用户是否被锁定'")
    private boolean locked = false;

    //@Column(columnDefinition = "COMMENT '用户是否被有效'")
    private boolean enabled = true;

    private String securityQuestion;

    private String securityAnswer;

    @CreatedDate
    private Date createTime;

    @LastModifiedDate
    private Date updateTime;


}
