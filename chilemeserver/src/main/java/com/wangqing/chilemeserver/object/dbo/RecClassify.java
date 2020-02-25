package com.wangqing.chilemeserver.object.dbo;

import lombok.Data;

import javax.persistence.*;

/**
 * 推荐分类
 * 需提前写入数据
 */
@Entity
@Data
public class RecClassify {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer classifyId;

    private String classifyName;
}
