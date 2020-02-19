package com.wangqing.chilemeserver.object.dto;

import lombok.Data;

/**
 * 给用户传输的显示在“我的”页面上的数据
 */
@Data
public class UserInfoDto {
    /* 用户id */
    private Integer userId;
    /* 用户昵称 */
    private String nickName;
//    /* 用户手机号 */
//    private String phoneNumber;
    /* 用户简介 */
    private String intro;
    /* 用户头像地址 */
    private String avatarUrl;
    /* 用户空间封面 */
    private String coverUrl;
    /* 关注数 */
    private Integer attentionNumber;
    /* 粉丝数 */
    private Integer fansNumber;
    /* 帖子数 */
    private Integer postNumber;
    /* 历史数 */
    private Integer historyNumber;
    /* 收藏数 */
    private Integer myFavoriteNumber;
    /* 点赞数 */
    private Integer myLikeNumber;
}
