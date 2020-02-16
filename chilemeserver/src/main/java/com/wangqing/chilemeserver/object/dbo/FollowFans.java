package com.wangqing.chilemeserver.object.dbo;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * 关注 、 粉丝 列表
 */
@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class FollowFans {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer followedId;

    private Integer fansId;

    private Boolean enable = true;

    @CreatedDate
    private LocalDateTime createTime;

    @LastModifiedDate
    private LocalDateTime updateTime;

}
