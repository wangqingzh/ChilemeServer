package com.wangqing.chilemeserver.service;

import com.wangqing.chilemeserver.object.dbo.MyFavorite;
import com.wangqing.chilemeserver.repository.MyFavoriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyFavoriteService {
    @Autowired
    MyFavoriteRepository myFavoriteRepository;

    public void giveAFavorite(Integer postId, Integer userId){
        MyFavorite myFavorite;
        Optional<MyFavorite> optional = myFavoriteRepository.findByPostIdAndUserId(postId, userId);
        if (optional.isPresent()){
            myFavorite = optional.get();
            myFavorite.setStatus(!myFavorite.getStatus());
        }else {
            myFavorite = MyFavorite.of(postId, userId);
        }
        myFavoriteRepository.saveAndFlush(myFavorite);

    }
}
