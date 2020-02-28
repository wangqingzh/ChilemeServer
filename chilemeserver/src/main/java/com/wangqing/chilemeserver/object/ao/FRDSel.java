package com.wangqing.chilemeserver.object.ao;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 美食推荐　查看详情　查询数据库用到的参数
 */
@Data
@AllArgsConstructor
public class FRDSel {
    private Integer postId;
    private Integer postUserId;
    private Integer userId;
}
