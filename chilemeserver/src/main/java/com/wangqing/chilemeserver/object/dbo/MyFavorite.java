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

    private Integer post_id;

    private Integer user_id;

    private Boolean is_delete = false;

    @CreatedDate
    private LocalDateTime create_time;

    @LastModifiedDate
    private LocalDateTime update_time;
}
