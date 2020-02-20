package com.wangqing.chilemeserver.object.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UploadFileDto {
    /* 用户头像 */
    public static final int USER_AVATAR = 0;
    /* 用户封面 */
    public static final int USER_COVER = 1;
    /* 帖子图片 */
    public static final int POST_IMAGE = 2;
    /* 评价图片 */
    public static final int EVALUATION_IMAGE = 3;

    private Integer typeCode;
    private Integer id;
}
