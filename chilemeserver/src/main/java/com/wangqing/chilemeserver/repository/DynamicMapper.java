package com.wangqing.chilemeserver.repository;

import com.wangqing.chilemeserver.object.dto.DynamicDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DynamicMapper {
    @Select("SELECT p.post_type AS postType, p.post_id AS postId, p.headline AS headline, p.create_time AS postTime, " +
            "       p.image_url AS postImage, p.user_id AS postUserId, ui.nick_name AS postUserName, ui.avatar_url AS postUserAvatar, " +
            "        (SELECT COUNT(*) FROM my_like my WHERE my.type = 0 AND my.type_id = p.post_id AND my.status = true) as likeNumber, " +
            "        IFNULL((SELECT status FROM my_like my WHERE my.type = 0 AND my.type_id = p.post_id AND my.user_id = ${userId}),0) as likeStatus, " +
            "        (SELECT COUNT(*) FROM comment cm WHERE cm.post_id = p.post_id) as commentNumber " +
            " FROM attention_fans af RIGHT OUTER JOIN post p ON af.attention_id = p.user_id INNER JOIN user_info ui ON p.user_id = ui.user_id " +
            " WHERE af.fans_id = ${userId} OR p.user_id = ${userId} " +
            " ORDER BY postTime DESC")
    List<DynamicDto> getDynamicList(@Param("userId") Integer userId);
}
