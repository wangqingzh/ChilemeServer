package com.wangqing.chilemeserver.service;

import com.wangqing.chilemeserver.object.dto.MessageLikeDto;
import com.wangqing.chilemeserver.object.dto.MessageReplyDto;
import com.wangqing.chilemeserver.repository.MessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    @Autowired(required = false)
    MessageMapper messageMapper;

    public List<MessageReplyDto> getMessageReply(Integer userId){
        return messageMapper.getMessageReply(userId);
    }

    public List<MessageLikeDto> getMessageLike(Integer userId){
        return messageMapper.getMessageLike(userId);
    }
}
