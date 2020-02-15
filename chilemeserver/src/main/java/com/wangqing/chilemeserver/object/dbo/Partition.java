package com.wangqing.chilemeserver.object.dbo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 发帖分区表
 * 需提前写入数据
 */
@Entity
@Data
public class Partition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer partitionId;

    private String partitionName;
}
