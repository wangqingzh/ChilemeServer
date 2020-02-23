package com.wangqing.chilemeserver.object.dbo;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * 美食推荐
 */

@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
public class CateRecommend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /* 帖子id */
    private Integer post_id;

    /* 帖子内容 */
    private String content;

    /* 推荐分区 */
    private Integer recommend_id;

    /* 综合推荐分数 */
    private float recommend_score;


    /* 创建时间 */
    @CreatedDate
    private LocalDateTime create_time;

    /* 更新时间 */
    @LastModifiedDate
    private LocalDateTime update_time;

}
