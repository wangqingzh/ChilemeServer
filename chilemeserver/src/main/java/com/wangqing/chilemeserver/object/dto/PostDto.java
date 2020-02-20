package com.wangqing.chilemeserver.object.dto;

import lombok.Data;

/**
 * 用户发帖时 传来的信息
 */
@Data
public class PostDto {
    private String headLine;
    /* 帖子内容 */
    private String content;
    /* 帖子分区 */
    private Integer partitionId;
    /* 综合推荐 */
    private float recommendScore;
    /* 发帖人 */
    private Integer postUserId;
}
