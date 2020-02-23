package com.wangqing.chilemeserver.repository;

import com.wangqing.chilemeserver.object.dbo.MyFavorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyFavoriteRepository extends JpaRepository<MyFavorite, Integer> {

    /* 根据用户id 查询用户的收藏数 */
    Integer countByUser_id(Integer userId);
}
