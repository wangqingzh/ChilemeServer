package com.wangqing.chilemeserver.repository;

import com.wangqing.chilemeserver.object.dto.FoodRecBrowserDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface FoodRecMapper {
    /* 根据推荐分类返回帖子信息 */
    @Select("SELECT fr.post_id AS postId, fr.create_time AS postTime, p.headline AS postHeadline, p.image_url AS postImageUrl, p.user_id AS userId," +
            "       ui.nick_name AS userName, ui.avatar_url AS userAvatar," +
            "       (SELECT COUNT(*) FROM my_like my WHERE my.type_id = fr.post_id AND my.status = true) as likeNumber," +
            "        IFNULL((SELECT status FROM my_like my WHERE my.type_id = fr.post_id AND my.user_id = ${userId}),0) as likeStatus," +
            "       (SELECT COUNT(*) FROM comment cm WHERE cm.post_id = fr.post_id) as commentNumber" +
            " FROM food_rec fr INNER JOIN post p ON fr.post_id = p.post_id INNER JOIN user_info ui ON p.user_id = ui.user_id" +
            " WHERE classify_id = ${classifyId}")
    List<FoodRecBrowserDto> foodRecBrowserByClassifyId(@Param("userId") Integer userId, @Param("classifyId") Integer classifyId);
}
