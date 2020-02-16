package com.wangqing.chilemeserver.object.dbo;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * 我点赞的 取数据时 连同浏览历史一起 算点赞率 参考 pornhub
 */
@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
public class MyLike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer postId;

    private Integer userId;

    private Boolean enable = true;

    @CreatedDate
    private LocalDateTime createTime;

    @LastModifiedDate
    private LocalDateTime updateTime;
}
