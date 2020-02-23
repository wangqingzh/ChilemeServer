package com.wangqing.chilemeserver.object.dbo;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * 浏览历史
 */
@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
public class BrowserHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer post_id;

    private Integer user_id;

    /* 创建时间 */
    @CreatedDate
    private LocalDateTime create_time;

    /* 更新时间 */
    @LastModifiedDate
    private LocalDateTime update_time;
}
