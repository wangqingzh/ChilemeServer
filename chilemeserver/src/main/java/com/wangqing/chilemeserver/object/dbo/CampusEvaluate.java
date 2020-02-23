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
    private Integer evaluate_id;

    /* 帖子id */
    private Integer post_id;
    /* 食堂id */
    private Integer hall_id;
    /* 点名 */
    private String store_name;

    private String dish;

    /* 点评内容 */
    private String content;

    /* 综合打分 */
    private float evaluate_score;

    /* 创建时间 */
    @CreatedDate
    private LocalDateTime create_time;

    /* 更新时间 */
    @LastModifiedDate
    private LocalDateTime update_time;



}
