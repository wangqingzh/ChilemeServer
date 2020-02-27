package com.wangqing.chilemeserver.object.dbo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * 点赞
 */
@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@RequiredArgsConstructor(staticName = "of")
public class MyLike {
    /* 主键 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /* 对应的帖子或评论id */
    @NonNull
    private Integer typeId;
    /* 0 帖子 1 评论  */
    @NonNull
    private Integer type;
    /* 点赞的用户id */
    @NonNull
    private Integer userId;
    /* 该条点赞时候有效 */
    private Boolean status = true;

    /* 创建时间 */
    @CreatedDate
    private LocalDateTime createTime;

    /* 更新时间 */
    @LastModifiedDate
    private LocalDateTime updateTime;
}
