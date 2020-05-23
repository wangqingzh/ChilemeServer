package com.wangqing.chilemeserver.repository;

import com.wangqing.chilemeserver.object.dto.FoodGalleryDto;
import com.wangqing.chilemeserver.object.dto.HotListDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MineMapper {
    @Select("SELECT post_id, post_type, headline, image_url, user_id " +
            "FROM post " +
            "WHERE  image_url IS NOT NULL AND user_id = ${userId}")
    List<FoodGalleryDto> getFoodGallery(Integer userId);

    @Select("SELECT COUNT(*) AS count , p.post_id, p.post_type, p.headline, p.user_id " +
            "FROM post p INNER JOIN my_like ml ON p.post_id = ml.type_id AND ml.type = 0 AND ml.status = true " +
            "WHERE  DATE_SUB(CURDATE(), INTERVAL 6 DAY) <= date(p.create_time) " +
            "GROUP BY p.post_id " +
            "ORDER BY count DESC  LIMIT 0,10")
    List<HotListDto> getHotList();
}
