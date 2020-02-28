package com.wangqing.chilemeserver.service;

import com.wangqing.chilemeserver.object.dbo.AttentionFans;
import com.wangqing.chilemeserver.repository.AttentionFansRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AttentionFansService {
    @Autowired
    AttentionFansRepository attentionFansRepository;

    public void attentionHandler(Integer attentionId, Integer fansId){
        AttentionFans attentionFans;
        Optional<AttentionFans> optional = attentionFansRepository.findByAttentionIdAndFansId(attentionId, fansId);
        if (optional.isPresent()){
            attentionFans = optional.get();
            attentionFans.setStatus(!attentionFans.getStatus());
        }else {
            attentionFans = AttentionFans.of(attentionId, fansId);
        }
        attentionFansRepository.saveAndFlush(attentionFans);
    }
}
