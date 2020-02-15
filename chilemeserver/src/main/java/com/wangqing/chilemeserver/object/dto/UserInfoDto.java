package com.wangqing.chilemeserver.object.dto;

/**
 * 给用户传输的显示在“我的”页面上的数据
 */
public class UserInfoDto {
    /* 用户id */
    private Integer userId;
    /* 用户昵称 */
    private String nickName = null;
    /* 用户简介 */
    private String intro = null;
    /* 用户头像地址 */
    private String avatarUrl = null;
    /* 关注数 */
    private Integer attentionNumber = 0;
    /* 粉丝数 */
    private Integer fansNumber = 0;
    /* 帖子数 */
    private Integer postNumber = 0;
    /* 历史数 */
    private Integer historyNumber = 0;
    /* 手长数 */
    private Integer myFavoriteNumber = 0;
    /* 点赞数 */
    private Integer myLikeNumber = 0;
}
