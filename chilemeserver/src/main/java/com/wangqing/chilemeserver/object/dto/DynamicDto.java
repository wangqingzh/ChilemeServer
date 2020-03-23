package com.wangqing.chilemeserver.object.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
public class DynamicDto {

    public static final Integer POST_EVALUATE = 0;
    public static final Integer POST_FOOD_REC = 1;

    private Integer postType;
    private Integer postId;
    private String headline;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    private Date postTime;
    private String postImage;

    private Integer postUserId;
    private String postUserName;
    private String postUserAvatar;

    private Integer likeNumber;
    private boolean likeStatus;

    private Integer commentNumber;
}