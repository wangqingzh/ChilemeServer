package com.wangqing.chilemeserver.object.dbo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 食堂分类
 * 需提前写入数据
 */
@Entity
@Data
public class HallClassify {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer classifyId;

    private String classifyName;
}
