package com.wangqing.chilemeserver.repository;

import com.wangqing.chilemeserver.object.dbo.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
    /* 根据发帖人的id 查询该发帖人发过的贴子数量 */
    Integer countByPostUserId(Integer postUserId);

    /* 保存更新 */
    @Override
    <S extends Post> S saveAndFlush(S entity);

}
