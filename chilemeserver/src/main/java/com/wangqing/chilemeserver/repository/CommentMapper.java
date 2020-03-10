package com.wangqing.chilemeserver.repository;

import com.wangqing.chilemeserver.object.dto.CommentBrowserDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CommentMapper {

    /**
     *  根据postId 获取　帖子的评论　
     *  根据访问用户的id　判断评论用户是否点赞
     */
    @Select("SELECT cm.post_id AS postId,cm.id AS commentId, cm.content AS comment, cm.from_uid AS fromUid, cm.to_uid AS toUid, " +
            "       cm.create_time AS writeTime, ui.nick_name AS userName, ui.avatar_url AS userAvatar, " +
            "       (SELECT  COUNT(*) FROM my_like my WHERE  my.type = 1 AND my.status = true AND my.type_id = cm.id) AS likeNumber, " +
            "       IFNULL((SELECT  status FROM my_like my WHERE  my.type = 1 AND my.user_id = ${userId} AND my.type_id = cm.id), 0) AS likeStatus " +
            "FROM comment cm INNER JOIN user_info ui ON cm.from_uid = ui.user_id " +
            "WHERE cm.post_id = ${postId}")
    List<CommentBrowserDto> getCommentByPostIdAndUserId(Integer postId, Integer userId);
}
