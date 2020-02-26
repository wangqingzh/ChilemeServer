package com.wangqing.chilemeserver.object.dto;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class FoodRecBrowserDto {

    /* 帖子号 */
    private Integer postId;
    /* 发帖时间 */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    private Date postTime;
    /* 帖子标题 */
    private String postHeadline;

    /* 帖子图片 */
    private String postImageUrl;


    /* 发帖人id */
    private Integer userId;
    /* 发帖人姓名 */
    private String userName;
    /* 发帖人头像 */
    private String userAvatar;


    /* 点赞数 */
    private Integer likeNumber;
    /* 用户 点赞状态 */
    private boolean likeStatus;
    /* 评论数 */
    private Integer commentNumber;


}