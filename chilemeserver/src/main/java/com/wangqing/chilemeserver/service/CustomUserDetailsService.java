package com.wangqing.chilemeserver.service;

import com.wangqing.chilemeserver.object.ao.User;
import com.wangqing.chilemeserver.object.dbo.UserDbo;
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
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository; //用于查询用户信息

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDbo userDbo = userRepository.findUserDboByIdentifier(username);
        if (userDbo == null){
            throw new UsernameNotFoundException("未查询到该用户");
        }
        User user = new User(userDbo.getIdentifier(), userDbo.getCredential(), userDbo.isEnabled(), userDbo.isLocked(), userRepository.getUserRolesByUid(userDbo.getUserId()));
        return user;
    }
}
