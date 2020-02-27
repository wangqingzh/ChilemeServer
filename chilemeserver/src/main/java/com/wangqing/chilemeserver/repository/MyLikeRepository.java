package com.wangqing.chilemeserver.repository;

import com.wangqing.chilemeserver.object.dbo.MyLike;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MyLikeRepository extends JpaRepository<MyLike, Integer> {
    /* 根据用户id 查询用户的点赞数 */
    Integer countByUserId(Integer userId);

    Optional<MyLike> findByTypeIdAndUserId(Integer typeId, Integer userId);

    @Override
    <S extends MyLike> S saveAndFlush(S entity);
}
