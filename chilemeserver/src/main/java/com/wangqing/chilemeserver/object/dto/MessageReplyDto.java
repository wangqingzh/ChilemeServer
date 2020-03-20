package com.wangqing.chilemeserver.object.dto;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * message reply
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageReplyDto {
    /* 评论类型 评论 回复 */
    private Integer commentType;
    /* 评论ID */
    private Integer commentId;
    /* 帖子类型 校园餐饮评价 美食推荐 */
    private Integer postType;
    /* 帖子ID */
    private Integer postId;
    /* 发帖人ID */
    private Integer postUserId;
    /* 回复内容 */
    private String replyContent;
    /* 原始内容 */
    private String originalContent;
    /* 评论时间 */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    private Date commentTime;
    /* 评论人ＩＤ */
    private Integer commentUserId;
    /* 评论人昵称 */
    private String commentUserName;
    /* 评论人头像 */
    private String commentUserAvatar;
}