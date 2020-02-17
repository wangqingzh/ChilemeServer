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

    /* 用户id */
    private Integer userId;
    /* 用户昵称 默认nikeName */
    private String nickName = "nikeName";
    /* 用户简介 */
    private String intro = null;
    /* 用户头像地址 */
    private String avatarUrl = null;
    /* 用户空间封面 */
    private String coverUrl = null;

    @CreatedDate
    private Date createTime;

    @LastModifiedDate
    private Date updateTime;
}
