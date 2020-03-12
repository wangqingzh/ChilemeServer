package com.wangqing.chilemeserver.object.dbo;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * 校园餐饮评价
 */
@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
public class CampusEvaluate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer evaluateId;

    /* 帖子id */
    private Integer postId;
    /* 食堂id */
    private Integer hallId;
    /* 店名 */
    private String storeName;
    /* 菜品 */
    private String dish;
    /* 点评内容 */
    private String content;

    /* 综合打分 */
    private float evaluateScore;

    /* 创建时间 */
    @CreatedDate
    private LocalDateTime createTime;

    /* 更新时间 */
    @LastModifiedDate
    private LocalDateTime updateTime;



}
