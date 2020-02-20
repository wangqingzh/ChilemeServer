package com.wangqing.chilemeserver.object.dto;

/**
 * 用户发帖时 传来的信息
 */
public class PostDto {
    private String headLine;
    /* 帖子内容 */
    private String content;
    /* 发布的图片链接 */
    private String imageUrl = null;
    /* 帖子分区 */
    private Integer partitionId;
    /* 综合推荐 */
    private float recommendScore;
    /* 发帖人 */
    private Integer postUserId;
}
