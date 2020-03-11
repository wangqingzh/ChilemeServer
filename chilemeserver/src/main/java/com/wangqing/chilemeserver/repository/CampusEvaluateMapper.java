package com.wangqing.chilemeserver.repository;

import com.wangqing.chilemeserver.object.dto.EvaluateBrowserDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CampusEvaluateMapper {
    @Select("SELECT p.post_id AS postId, p.create_time AS postTime, p.headline AS postHeadline, p.image_url AS postImageUrl," +
            "       (ce.store_name + ' | ' + ce.dish) AS storeNameDish, p.user_id AS userId, ui.nick_name AS userName, ui.avatar_url AS userAvatar," +
            "        (SELECT COUNT(*) FROM my_like my WHERE my.type = 0 AND my.type_id = p.post_id AND my.status = true) as likeNumber," +
            "        IFNULL((SELECT status FROM my_like my WHERE my.type = 0 AND my.type_id = p.post_id AND my.user_id = ${userId}),0) as likeStatus," +
            "        (SELECT COUNT(*) FROM comment cm WHERE cm.post_id = p.post_id) as commentNumber" +
            "FROM campus_evaluate ce INNER JOIN post p ON ce.post_id = p.post_id INNER  JOIN user_info ui ON p.user_id = ui.user_id" +
            "WHERE   ce.hall_id = ${hallId}")
    List<EvaluateBrowserDto> getEvaluate(@Param("userId") Integer userId, @Param("hallId") Integer hallId);
}
