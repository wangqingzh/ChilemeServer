package com.wangqing.chilemeserver.service;

import com.wangqing.chilemeserver.object.ao.User;
import com.wangqing.chilemeserver.object.dbo.UserDbo;
import com.wangqing.chilemeserver.object.dbo.UserInfo;
import com.wangqing.chilemeserver.object.dbo.UserRole;
import com.wangqing.chilemeserver.object.dto.SignUpDto;
import com.wangqing.chilemeserver.repository.UserInfoRepository;
import com.wangqing.chilemeserver.repository.UserRepository;
import com.wangqing.chilemeserver.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * 用户登录 注册 修改密码 找回密码 服务
 */
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserRoleRepository userRoleRepository;

    @Autowired
    UserInfoRepository userInfoRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    /**
     * 创建新用户
     *
     * @param signUpDto
     */
    public void createUser(SignUpDto signUpDto) {
//        Integer userId = (int) ((Math.random() * 9 + 1) * 100000);
//
//        while (userRepository.existsById(userId)) {
//            userId = (int) ((Math.random() * 9 + 1) * 100000);
//        }
        UserDbo userDbo = new UserDbo();
        //userDbo.setUserId(userId);
        userDbo.setIdentifier(signUpDto.getIdentifier());
        userDbo.setCredential(passwordEncoder.encode(signUpDto.getCredential()));
        userDbo.setSecurityQuestion(signUpDto.getSecurityQuestion());
        userDbo.setSecurityAnswer(signUpDto.getSecurityAnswer());

        userDbo = userRepository.save(userDbo);
        // 向用户添加角色
        userRoleRepository.save(UserRole.of(userDbo.getUserId(), 3));
        // 向用户信息表初始化该用户信息
        userInfoRepository.save(UserInfo.of(userDbo.getUserId()));
    }
}
