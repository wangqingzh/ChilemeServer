package com.wangqing.chilemeserver.repository;

import com.wangqing.chilemeserver.object.dbo.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {


    /* 根据用户id 将用户的信息查出 */
    UserInfo findByUserId(Integer userId);

    /* 根据用户id 修改昵称 */
    @Transactional
    @Modifying
    @Query(value = "UPDATE user_info SET nike_name = ?1 WHERE user_id = ?2", nativeQuery = true)
    int updateNikeNameByUserId(String nikeName, Integer userId);

    /* 根据用户id 修改简介 */
    @Transactional
    @Modifying
    @Query(value = "UPDATE user_info SET intro = ?1 WHERE user_id = ?2", nativeQuery = true)
    int updateIntroByUserId(String intro, Integer userId);

    /* 根据用户id 修改头像存储地址 */
    @Transactional
    @Modifying
    @Query(value = "UPDATE user_info SET avatar_url = ?1 WHERE user_id = ?2", nativeQuery = true)
    int updateAvatarUrlByUserId(String avatarUrl, Integer userId);

    /* 根据用户id 修改封面存储地址 */
    @Transactional
    @Modifying
    @Query(value = "UPDATE user_info SET cover_url = ?1 WHERE user_id = ?2", nativeQuery = true)
    int updateCoverUrlByUserId(String coverUrl, Integer userId);

}
