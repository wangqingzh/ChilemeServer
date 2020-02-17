package com.wangqing.chilemeserver.service;

import com.wangqing.chilemeserver.object.dbo.UserInfo;
import com.wangqing.chilemeserver.object.dto.UserInfoDto;
import com.wangqing.chilemeserver.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MineService {
    @Autowired
    UserInfoRepository userInfoRepository;
    @Autowired
    AttentionFansRepository attentionFansRepository;
    @Autowired
    PostRepository postRepository;
    @Autowired
    BrowserHistoryRepository browserHistoryRepository;
    @Autowired
    MyFavoriteRepository myFavoriteRepository;
    @Autowired
    MyLikeRepository myLikeRepository;


    public UserInfoDto getUserInfoDtoByUserId(Integer userId){
        UserInfo userInfo = userInfoRepository.findByUserId(userId); //存储在数据库的数据
        Integer attentionNumber = attentionFansRepository.countByFansId(userId); // 查询关注数
        Integer fansNumber = attentionFansRepository.countByAttentionId(userId); // 查询粉丝数
        Integer postNumber = postRepository.countByPostUserId(userId); // 发帖数
        Integer historyNumber = browserHistoryRepository.countByUserId(userId); // 浏览历史数
        Integer myFavoriteNumber = myFavoriteRepository.countByUserId(userId); // 收藏数
        Integer myLikeNumber = myLikeRepository.countByUserId(userId); // 点赞数

        UserInfoDto userInfoDto = new UserInfoDto();
        userInfoDto.setUserId(userInfo.getUserId());
        userInfoDto.setNickName(userInfo.getNickName());
        userInfoDto.setIntro(userInfo.getCoverUrl());
        userInfoDto.setAvatarUrl(userInfo.getAvatarUrl());
        userInfoDto.setCoverUrl(userInfo.getCoverUrl());
        userInfoDto.setAttentionNumber(attentionNumber);
        userInfoDto.setFansNumber(fansNumber);
        userInfoDto.setPostNumber(postNumber);
        userInfoDto.setHistoryNumber(historyNumber);
        userInfoDto.setMyFavoriteNumber(myFavoriteNumber);
        userInfoDto.setMyLikeNumber(myLikeNumber);
        return userInfoDto; // 返回给前端
    }
}
