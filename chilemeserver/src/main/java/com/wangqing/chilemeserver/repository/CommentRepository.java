package com.wangqing.chilemeserver.repository;

import com.wangqing.chilemeserver.object.dbo.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
    /* 添加评论 */
    @Override
    <S extends Comment> S saveAndFlush(S entity);

    /* 查询有效评论 */
    List<Comment> findByPostIdAndStatus(Integer postId, boolean status);
}
