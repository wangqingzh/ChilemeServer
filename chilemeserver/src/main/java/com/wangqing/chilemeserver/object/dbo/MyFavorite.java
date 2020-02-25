package com.wangqing.chilemeserver.object.dbo;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * 我的收藏
 */
@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class MyFavorite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer postId;

    private Integer userId;

    private Boolean isDelete = false;

    /* 创建时间 */
    @CreatedDate
    private LocalDateTime createTime;

    /* 更新时间 */
    @LastModifiedDate
    private LocalDateTime updateTime;
}
