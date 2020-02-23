package com.wangqing.chilemeserver.repository;

import com.wangqing.chilemeserver.object.dbo.AttentionFans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttentionFansRepository extends JpaRepository<AttentionFans, Integer> {

    /* 根据粉丝的id 查询关注数量 */
    Integer countByFans_id(Integer fansId);

    /* 根据被关注者的id 查询粉丝数量 */
    Integer countByAttention_id(Integer attentionId);
}
