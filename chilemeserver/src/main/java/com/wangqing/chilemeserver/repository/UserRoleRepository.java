package com.wangqing.chilemeserver.repository;

import com.wangqing.chilemeserver.object.dbo.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {
}
