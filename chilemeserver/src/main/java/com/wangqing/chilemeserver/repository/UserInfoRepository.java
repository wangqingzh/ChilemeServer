package com.wangqing.chilemeserver.repository;

import com.wangqing.chilemeserver.object.dbo.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {
    /* 根据用户id 将用户的信息查出 */
    UserInfo findByUserId(Integer userId);
}
