package com.wangqing.chilemeserver.service;

import com.wangqing.chilemeserver.object.ao.User;
import com.wangqing.chilemeserver.object.dbo.UserDb;
import com.wangqing.chilemeserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * 自定义用户服务 在这里从数据库查询并返回用户信息
 * 在SecurityConfig中替换掉默认的UserDetailService
 */
@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserRepository userRepository; //用于查询用户信息

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDb userDB = userRepository.findUserDBByIdentifier(username);
        if (userDB == null){
            throw new UsernameNotFoundException("未查询到该用户");
        }
        User user = new User(userDB.getIdentifier(), userDB.getCredential(), userDB.isEnabled(), userDB.isLocked(), userRepository.getUserRolesByUid(userDB.getUserId()));
        return user;
    }
}
