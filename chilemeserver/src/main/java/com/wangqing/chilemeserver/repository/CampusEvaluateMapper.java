package com.wangqing.chilemeserver.repository;

import com.wangqing.chilemeserver.object.dto.CESel;
import com.wangqing.chilemeserver.object.dto.EvaluateBrowserDto;
import com.wangqing.chilemeserver.object.dto.EvaluateDetailDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CampusEvaluateMapper {
    @Select("SELECT p.post_id AS postId, p.create_time AS postTime, p.headline AS postHeadline, p.image_url AS postImageUrl," +
            "       CONCAT(store_name , ' | ',  dish) AS storeNameDish, p.user_id AS userId, ui.nick_name AS userName, ui.avatar_url AS userAvatar," +
            "        (SELECT COUNT(*) FROM my_like my WHERE my.type = 0 AND my.type_id = p.post_id AND my.status = true) as likeNumber," +
            "        IFNULL((SELECT status FROM my_like my WHERE my.type = 0 AND my.type_id = p.post_id AND my.user_id = ${userId}),0) as likeStatus," +
            "        (SELECT COUNT(*) FROM comment cm WHERE cm.post_id = p.post_id) as commentNumber " +
            "FROM campus_evaluate ce INNER JOIN post p ON ce.post_id = p.post_id INNER  JOIN user_info ui ON p.user_id = ui.user_id " +
            "WHERE   ce.hall_id = ${hallId}")
    List<EvaluateBrowserDto> getEvaluate(@Param("userId") Integer userId, @Param("hallId") Integer hallId);


    @Select("SELECT  p.post_id AS postId, p.create_time AS postTime, p.headline AS postHeadline, p.image_url AS postImageUrl, " +
            "ce.store_name AS storeName, ce.dish AS dish," +
            "ce.content AS content, ce.evaluate_score AS evaluateScore, ui.user_id AS userId, ui.nick_name AS userName, " +
            "ui.avatar_url AS userAvatar, " +
            "(SELECT COUNT(*) FROM my_like my WHERE my.type = 0 AND my.type_id = p.post_id AND my.status = true) as likeNumber, " +
            "IFNULL((SELECT status FROM my_like my WHERE my.type = 0 AND my.type_id = ce.post_id AND my.user_id = ${userId}),0) as likeStatus, " +
            "(SELECT COUNT(*) FROM my_favorite mf WHERE mf.post_id = p.post_id AND mf.status = true) as favoriteNumber, " +
            "IFNULL((SELECT status FROM my_favorite mf WHERE mf.post_id = p.post_id AND mf.user_id = ${userId}),0) as favoriteStatus, " +
            "(SELECT COUNT(*) FROM comment cm WHERE cm.post_id = p.post_id AND cm.status = true) as commentNumber, " +
            "IFNULL((SELECT status FROM attention_fans af WHERE af.attention_id = ${postUserId} AND af.fans_id = ${userId} AND af.status = true ),0) as attentionStatus " +
            "FROM  post p INNER JOIN campus_evaluate ce ON p.post_id = ce.post_id  INNER  JOIN user_info ui ON p.user_id = ui.user_id " +
            "WHERE  p.post_id = ${postId}")
    EvaluateDetailDto getEvaluateDetailByCESel(CESel ceSel);
}
