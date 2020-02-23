package com.wangqing.chilemeserver.object.dbo;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * 评论表 盖楼模式
 */
@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Comment {
    /* 评论id */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /* 主题id */
    private Integer post_id;
    /* 评论 */
    private String content;
    /* 评论用户 */
    private Integer from_uid;
    /* 被回复用户 当评论帖子时 to_uid 为空 */
    private Integer to_uid;
    /* 是否被删除 默认 否 */
    private boolean is_delete = false;

    @CreatedDate
    private LocalDateTime create_time;

    @LastModifiedDate
    private LocalDateTime update_time;
}
