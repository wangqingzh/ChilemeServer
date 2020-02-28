package com.wangqing.chilemeserver.web.api;

import com.wangqing.chilemeserver.object.ao.CommonResult;
import com.wangqing.chilemeserver.object.ao.FRDSel;
import com.wangqing.chilemeserver.object.dto.FoodRecBroReqDto;
import com.wangqing.chilemeserver.object.dto.FoodRecBrowserDto;
import com.wangqing.chilemeserver.object.dto.FoodRecPostDto;
import com.wangqing.chilemeserver.service.FoodRecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/food_rec")
public class FoodRecApi {
    @Autowired
    FoodRecService foodRecService;

    /**
     * 美食推荐 发帖接口
     * @param postDto
     * @return
     */
    @PostMapping("/post")
    public HttpEntity<?> addPost(@RequestBody FoodRecPostDto postDto){
        Integer postId = foodRecService.addPost(postDto); // 返回postId 用于上传图片
        return new ResponseEntity<>(CommonResult.success(postId), HttpStatus.OK);
    }

    /**
     * 根据推荐分类 获取全部信息
     * @return
     */
    @PostMapping("/browser")
    public HttpEntity<?> BrowserByClassifyId(@RequestBody FoodRecBroReqDto foodRecBroReqDto){
        List<FoodRecBrowserDto> foodRecBrowserDtoList = foodRecService.foodRecBrowserByClassifyId(foodRecBroReqDto);
        return new ResponseEntity<>(CommonResult.success(foodRecBrowserDtoList), HttpStatus.OK);
    }

    @PostMapping("/detail")
    public HttpEntity<?> DetailByFRDSel(@RequestBody FRDSel frdSel){
        return new ResponseEntity<>(CommonResult.success(foodRecService.foodRecDetailByFRDSel(frdSel)), HttpStatus.OK);
    }
}
