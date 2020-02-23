package com.wangqing.chilemeserver.object.dbo;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * 帖子
 */
@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
public class Post {
    /* 帖子id */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer post_id;
    /* 帖子类型 0 校园餐饮 1 美食推荐 */
    private Integer post_type;

    /* 帖子标题 */
    private String headline;

    /* 发布的图片链接 */
    private String image_url = null;

    /* 发帖人 */
    private Integer post_user_id;


    /* 默认有效 false为删除 */
    private boolean enable = true;


    /* 创建时间 */
    @CreatedDate
    private LocalDateTime create_time;

    /* 更新时间 */
    @LastModifiedDate
    private LocalDateTime update_time;
}
