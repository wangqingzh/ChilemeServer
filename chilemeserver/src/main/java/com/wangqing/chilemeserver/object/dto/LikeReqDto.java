package com.wangqing.chilemeserver.object.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LikeReqDto {
    /* 点赞的id */
    private Integer typeId;
    /* 0 帖子 1 评论  */
    private Integer type;
    /* 点赞的用户id */
    private Integer userId;
}
