package com.wangqing.chilemeserver.object.dbo;

import lombok.Data;

import javax.persistence.*;

/**
 * 发帖分区表
 * 需提前写入数据
 */
@Entity
@Data
public class PostPartition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer partitionId;

    private String partitionName;
}
