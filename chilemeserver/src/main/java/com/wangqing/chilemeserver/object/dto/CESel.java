package com.wangqing.chilemeserver.object.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 校园餐饮评价　详情　查询
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CESel {
    private Integer postId;
    private Integer postUserId;
    private Integer userId;
}
