package com.wangqing.chilemeserver.repository;

import com.wangqing.chilemeserver.object.dbo.BrowserHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrowserHistoryRepository extends JpaRepository<BrowserHistory, Integer> {

    /* 根据 userId 查询用户浏览历史数 */
    Integer countByUserId(Integer userId);
}
