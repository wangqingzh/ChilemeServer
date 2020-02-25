package com.wangqing.chilemeserver.repository;

import com.wangqing.chilemeserver.object.dbo.Post;
import com.wangqing.chilemeserver.object.dto.FoodRecPostDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {


    /* 根据发帖人的id 查询该发帖人发过的贴子数量 */
    Integer countByUserId(Integer postUserId);

    /* 保存更新 */
    @Override
    <S extends Post> S saveAndFlush(S entity);

    /* 根据用户id 修改封面存储地址 */
    @Transactional
    @Modifying
    @Query(value = "UPDATE post SET image_url = ?1 WHERE post_id = ?2", nativeQuery = true)
    int updateImageUrlByPostId(String imageUrl, Integer postId);


}
