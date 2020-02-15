package com.wangqing.chilemeserver.object.dbo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * 用户信息表
 */
@Entity
@Data
@NoArgsConstructor
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer userId;
    //@Column(columnDefinition = "COMMENT '用户昵称'")
    private String nickName;
    /** 简介 */
    private String intro;
    //@Column(columnDefinition = "COMMENT '用户头像地址'")

    private String avatarUrl;

    @CreatedDate
    private Date createTime;

    @LastModifiedDate
    private Date updateTime;
}
