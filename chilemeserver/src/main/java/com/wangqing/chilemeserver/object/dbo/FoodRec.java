package com.wangqing.chilemeserver.object.dbo;

import lombok.*;
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
@NoArgsConstructor
@RequiredArgsConstructor(staticName = "of")
public class FoodRec {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    /* 帖子id */
    private Integer postId;

    @NonNull
    /* 帖子内容 */
    private String content;

    @NonNull
    /* 推荐分类 */
    private Integer classifyId;

    @NonNull
    /* 综合推荐分数 */
    private float recommendScore;


    /* 创建时间 */
    @CreatedDate
    private LocalDateTime createTime;

    /* 更新时间 */
    @LastModifiedDate
    private LocalDateTime updateTime;

}
