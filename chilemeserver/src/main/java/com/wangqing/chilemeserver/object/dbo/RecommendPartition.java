package com.wangqing.chilemeserver.object.dbo;

import lombok.Data;

import javax.persistence.*;

/**
 * 推荐分区
 * 需提前写入数据
 */
@Entity
@Data
public class RecommendPartition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer partition_id;

    private String partition_name;
}
