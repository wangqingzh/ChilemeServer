package com.wangqing.chilemeserver.object.dbo;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * 美食推荐贴
 */
@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
public class Post {
    /* 帖子id */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postId;
    /* 帖子标题 */
    private String headLine;
    /* 帖子内容 */
    private String content;
    /* 发布的图片链接 */
    private String imageUrl;
    /* 帖子分区 */
    private Integer partitionId;
    /* 综合推荐 */
    private float recommendScore;
    /* 发帖人 */
    private Integer postUserId;
    /* 默认有效 false为删除 */
    private boolean enable = true;
    /* 创建时间 */
    @CreatedDate
    private LocalDateTime timestamps;
}
