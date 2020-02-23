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
public class AttentionFans {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer attention_id;

    private Integer fans_id;

    private Boolean enable = true;

    @CreatedDate
    private LocalDateTime create_id;

    @LastModifiedDate
    private LocalDateTime update_id;
}
