package com.wangqing.chilemeserver.web.api;

import com.wangqing.chilemeserver.object.ao.CommonResult;
import com.wangqing.chilemeserver.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 消息接口
 */
@RestController
@RequestMapping("/api/v1/message")
public class MessageApi {
    @Autowired
    MessageService messageService;

    /**
     * 根据用户id返回　评论与回复
     * @param userId
     * @return
     */
    @GetMapping("/reply/{userId}")
    public HttpEntity<?> getMessageReply(@PathVariable Integer userId){
        return new ResponseEntity<>(CommonResult.success(messageService.getMessageReply(userId)), HttpStatus.OK);
    }

    /**
     * 根据用户id 返回用户点赞列表
     * @param userId
     * @return
     */
    @GetMapping("/like/{userId}")
    public HttpEntity<?> getMessageLike(@PathVariable Integer userId){
        return new ResponseEntity<>(CommonResult.success(messageService.getMessageLike(userId)), HttpStatus.OK);
    }
}
