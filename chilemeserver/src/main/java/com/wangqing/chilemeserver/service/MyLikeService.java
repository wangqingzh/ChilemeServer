package com.wangqing.chilemeserver.service;

import com.wangqing.chilemeserver.object.dto.LikeReqDto;
import com.wangqing.chilemeserver.repository.MyLikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wangqing.chilemeserver.object.dbo.MyLike;
import java.util.Optional;

@Service
public class MyLikeService {
    @Autowired
    MyLikeRepository myLikeRepository;

    /**
     * 点赞处理
     * @param likeReqDto
     */
    public void giveALike(LikeReqDto likeReqDto){
        Integer typeId = likeReqDto.getTypeId();
        Integer userId = likeReqDto.getUserId();
        Integer type = likeReqDto.getType();
        MyLike myLike;
        Optional<MyLike> optional = myLikeRepository.findByTypeIdAndUserId(typeId, userId);
        if (optional.isPresent()){
            myLike = optional.get();
            myLike.setStatus(!myLike.getStatus());
        }else {
            myLike = MyLike.of(typeId, type, userId);
        }
        myLikeRepository.saveAndFlush(myLike); // 写入或更新
    }
}
