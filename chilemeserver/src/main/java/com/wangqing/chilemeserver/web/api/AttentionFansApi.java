package com.wangqing.chilemeserver.web.api;

import com.wangqing.chilemeserver.object.ao.CommonResult;
import com.wangqing.chilemeserver.object.dbo.AttentionFans;
import com.wangqing.chilemeserver.service.AttentionFansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 关注与粉丝接口
 */
@RestController
@RequestMapping("/api/v1/attention_fans")
public class AttentionFansApi {
    @Autowired
    AttentionFansService attentionFansService;

    public HttpEntity<?> attentionHandler(@RequestParam("attentionId") Integer attentionId, @RequestParam("fansId") Integer fansId){
        attentionFansService.attentionHandler(attentionId, fansId);
        return new ResponseEntity<>(CommonResult.success(), HttpStatus.OK);
    }
}
