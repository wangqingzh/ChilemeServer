package com.wangqing.chilemeserver.repository;

import com.wangqing.chilemeserver.object.dbo.Role;
import com.wangqing.chilemeserver.object.dbo.UserDbo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 处理用户信息的仓库
 */
@Repository
public interface UserRepository extends JpaRepository<UserDbo, Integer> {

    UserDbo findUserDboByIdentifier(String identifier);

    /**
     * 多字段查询方法 JPQL 还有一种Map转换的办法即json(查询出来的Obecjt[]转换)->object
     * @param uid
     * @return
     */
    @Query(value = "select new com.wangqing.chilemeserver.object.dbo.Role(r.id, r.name, r.nameZh) " +
            "from com.wangqing.chilemeserver.object.dbo.Role r, com.wangqing.chilemeserver.object.dbo.UserRole ur where r.id=ur.rid and ur.uid= ?1")
    List<Role> getUserRolesByUid(Integer uid);




}
