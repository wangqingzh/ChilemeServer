package com.wangqing.chilemeserver.object.dbo;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 用户角色关系表
 */
@Data
@NoArgsConstructor
@Entity
@RequiredArgsConstructor(staticName = "of")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NonNull
    private Integer uid;
    @NonNull
    private Integer rid;
}
