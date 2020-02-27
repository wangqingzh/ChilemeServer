package com.wangqing.chilemeserver.object.dto;

import lombok.Data;

@Data
public class CommentPostDto {
    /* 主题id */
    private Integer postId;
    /* 评论 */
    private String content;
    /* 评论用户 */
    private Integer fromUid;
    /* 被回复用户 当评论帖子时 to_uid 为空 */
    private Integer toUid;
}
