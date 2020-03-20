package com.wangqing.chilemeserver.repository;

import com.wangqing.chilemeserver.object.dto.MessageLikeDto;
import com.wangqing.chilemeserver.object.dto.MessageReplyDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;

@Mapper
public interface MessageMapper {
    /**
     * 根据用户id 返回用户收到的回复
     * @param userId
     * @return
     */
    @Select("SELECT p.post_type AS postType, p.post_id AS postId, p.user_id AS postUserId, " +
            "       p.headline AS originalContent, c.id AS commentId,  c.content AS replyContent, " +
            "       (CASE  WHEN c.to_uid IS NULL THEN 0 WHEN c.to_uid IS NOT NULL THEN 1 END) AS commentType, " +
            "        c.create_time AS commentTime, ui.user_id AS commentUserId, ui.nick_name AS commentUserName, " +
            "       ui.avatar_url AS commentUserAvatar " +
            " FROM post p INNER JOIN comment c ON p.post_id = c.post_id  INNER JOIN user_info ui ON c.from_uid = ui.user_id " +
            " WHERE p.user_id = ${userId} OR c.to_uid = ${userId}")
    List<MessageReplyDto> getMessageReply(Integer userId);


    @Select("SELECT ml.type AS likeType, p.headline AS content, ml.create_time AS likeTime, " +
            "       p.post_type AS postType, p.post_id AS postId, p.user_id AS postUserId, " +
            "       ui.user_id AS likeUserId, ui.nick_name AS likeUserName, ui.avatar_url AS likeUserAvatar " +
            "FROM post p INNER  JOIN  my_like ml ON p.post_id = ml.type_id INNER JOIN user_info ui ON ml.user_id = ui.user_id " +
            "WHERE p.user_id = ${userId} AND ml.status = true " +
            "UNION ALL " +
            "SELECT ml.type AS likeType, c.content AS content, ml.create_time AS likeTime, " +
            "       p.post_type AS postType, p.post_id AS postId, p.user_id AS postUserId, " +
            "       ui.user_id AS likeUserId, ui.nick_name AS likeUserName, ui.avatar_url AS likeUserAvatar " +
            "FROM comment c  INNER JOIN  my_like ml ON  c.id = ml.type_id INNER JOIN post p ON c.post_id = p.post_id INNER  JOIN user_info ui ON ml.user_id = ui.user_id " +
            "WHERE c.from_uid = ${userId} AND ml.status = true " +
            "ORDER BY likeTime DESC")
    List<MessageLikeDto> getMessageLike(Integer userId);
}
