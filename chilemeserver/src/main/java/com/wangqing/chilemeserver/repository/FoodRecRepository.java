package com.wangqing.chilemeserver.repository;

import com.wangqing.chilemeserver.object.dbo.FoodRec;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRecRepository extends JpaRepository<FoodRec, Integer> {
    @Override
    <S extends FoodRec> S saveAndFlush(S entity);


}
