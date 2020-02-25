package com.wangqing.chilemeserver.repository;

import com.wangqing.chilemeserver.object.dbo.FoodRec;
import com.wangqing.chilemeserver.object.dto.FoodRecBrowserDto;
import com.wangqing.chilemeserver.object.dto.FoodRecPostDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface FoodRecRepository extends JpaRepository<FoodRec, Integer> {
    @Override
    <S extends FoodRec> S saveAndFlush(S entity);

    /* 根据推荐分类返回帖子信息 */
//    @Transactional
//    @Modifying
//    @Query(value = "SELECT new com.wangqing.chilemeserver.object.dto.FoodRecBrowserDto(" +
//            "fr.postId, fr.createTime, p.headline, p.imageUrl, p.userId, ui.nickName, ui.avatarUrl," +
//            "(SELECT COUNT(1) FROM MyLike my WHERE my.typeId = p.postId),  " +
//            "(SELECT status FROM MyLike my WHERE my.userId = ?1), " +
//            "(SELECT COUNT(1) FROM Comment c WHERE c.postId = p.postId)) " +
//            "FROM FoodRec fr INNER JOIN Post p ON fr.postId = p.postId " +
//            "INNER JOIN UserInfo ui ON p.userId = ui.userId WHERE fr.classifyId = ?2")
//    List<FoodRecBrowserDto> foodRecBrowserByClassifyId(Integer userId, Integer classifyId);

}
