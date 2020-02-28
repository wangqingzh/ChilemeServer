package com.wangqing.chilemeserver.repository;

import com.wangqing.chilemeserver.object.dbo.AttentionFans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AttentionFansRepository extends JpaRepository<AttentionFans, Integer> {

    /* 根据粉丝的id 查询关注数量 */
    Integer countByFansId(Integer fansId);

    /* 根据被关注者的id 查询粉丝数量 */
    Integer countByAttentionId(Integer attentionId);

    Optional<AttentionFans> findByAttentionIdAndFansId(Integer attentionId, Integer fansId);

    @Override
    <S extends AttentionFans> S saveAndFlush(S entity);
}
