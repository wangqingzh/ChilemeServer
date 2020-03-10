package com.wangqing.chilemeserver.object.dto;

import lombok.Data;

/**
 * 校园餐饮评价贴
 */
@Data
public class EvaluatePostDto {
    /* 标题 */
    private String headline;
    /* 店名 */
    private String storeName;
    /* 菜品 */
    private String dish;
    /* 点评 */
    private String content;
    /* 食堂 */
    private Integer hallId;
    /* 打分 */
    private float evaluateScore;
    /* 发帖人 */
    private Integer postUserId;
}
