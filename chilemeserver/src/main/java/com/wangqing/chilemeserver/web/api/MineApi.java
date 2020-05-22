package com.wangqing.chilemeserver.web.api;

import com.wangqing.chilemeserver.object.ao.CommonResult;
import com.wangqing.chilemeserver.object.dto.ModifyFieldByUserIdDto;
import com.wangqing.chilemeserver.object.dto.UserInfoDto;
import com.wangqing.chilemeserver.repository.MineMapper;
import com.wangqing.chilemeserver.repository.UserInfoRepository;
import com.wangqing.chilemeserver.repository.UserRepository;
import com.wangqing.chilemeserver.service.MineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 我的页面有关的信息返回与控制
 * 需要access_token访问
 */
@RestController
@RequestMapping("/api/v1/mine")
public class MineApi {
    @Autowired
    MineService mineService;
    @Autowired
    UserInfoRepository userInfoRepository; // 用户信息仓库
    @Autowired
    UserRepository userRepository; // 用户核心信息仓库

    @Autowired(required = false)
    MineMapper mineMapper;

    /**
     * 返回用户信息 展示在我的页面上
     * @param userId
     * @return
     */
    @GetMapping("/{userId}")
    public HttpEntity<?> getUserInfoByUserId(@PathVariable Integer userId){
        UserInfoDto userInfoDto = mineService.getUserInfoDtoByUserId(userId);
        CommonResult commonResult = CommonResult.success(userInfoDto);
        return new ResponseEntity<>(commonResult, HttpStatus.OK);
    }

    /* 个人信息 */

    /**
     * 修改昵称
     * @param nikeName
     * @return
     */
    @PutMapping("/info/nikeName")
    public HttpEntity<?> modifyNikeNameByUserId(@RequestBody ModifyFieldByUserIdDto nikeName){
        userInfoRepository.updateNikeNameByUserId(nikeName.getField(), nikeName.getUserId());
        return new ResponseEntity<>(CommonResult.success(), HttpStatus.OK);
    }

    /**
     * 修改简介
     * @param intro
     * @return
     */
    @PutMapping("/info/intro")
    public HttpEntity<?> modifyIntroByUserId(@RequestBody ModifyFieldByUserIdDto intro){
        userInfoRepository.updateIntroByUserId(intro.getField(), intro.getUserId());
        return new ResponseEntity<>(CommonResult.success(), HttpStatus.OK);
    }

    /* 设置 */

    /**
     * 修改手机号
     * @param phone
     * @return
     */
    @PutMapping("/setting/phone")
    public HttpEntity<?> modifyPhoneByUserId(@RequestBody ModifyFieldByUserIdDto phone){
        userRepository.updateIdentifierByUserId(phone.getField(), phone.getUserId());
        return new ResponseEntity<>(CommonResult.success(), HttpStatus.OK);
    }

    /**
     * 修改账户密码
     * @param phone
     * @return
     */
    @PutMapping("/setting/password")
    public HttpEntity<?> modifyPasswordByUserId(@RequestBody ModifyFieldByUserIdDto phone){
        userRepository.updateCredentialByUserId(phone.getField(), phone.getUserId());
        return new ResponseEntity<>(CommonResult.success(), HttpStatus.OK);
    }

    @GetMapping("/gallery/{userId}")
    public HttpEntity<?> getGallery(@PathVariable("userId") int userId){
        return new ResponseEntity<>(CommonResult.success(mineMapper.getFoodGallery(userId)), HttpStatus.OK);
    }

    @GetMapping("/hotList")
    public HttpEntity<?> getHotList(){
        return new ResponseEntity<>(CommonResult.success(mineMapper.getHotList()), HttpStatus.OK);
    }

}
