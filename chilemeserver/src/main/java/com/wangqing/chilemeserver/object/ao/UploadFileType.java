package com.wangqing.chilemeserver.object.ao;

public enum UploadFileType {

    USER_AVATAR("用户头像", 0),
    USER_COVER("用户封面", 1),
    POST_IMAGE("帖子图片", 2),
    EVALUATION_IMAGE("评价图片", 3);

    private String description;
    private Integer code;

    UploadFileType(String description, Integer code){
        this.description = description;
        this.code = code;
    }
}
