package com.wangqing.chilemeserver.repository;

import com.wangqing.chilemeserver.object.dbo.CampusEvaluate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampusEvaluateRepository extends JpaRepository<CampusEvaluate, Integer> {
    @Override
    <S extends CampusEvaluate> S saveAndFlush(S entity);
}
