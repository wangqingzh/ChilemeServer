package com.wangqing.chilemeserver.object.ao;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * web api 返回的通用结果集
 */
@Data
public class CommonResult {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    /* 时间戳 */
    private LocalDateTime timestamp;
    /* 内部结果码 */
    private Integer code;
    /* 结果信息 */
    private String message;
    /* 数据 */
    private Object data;

    public static CommonResult success(){
        CommonResult commonResult = new CommonResult();
        commonResult.timestamp = LocalDateTime.now();
        commonResult.code = ResultCode.SUCCESS.code();
        commonResult.message = ResultCode.SUCCESS.message();
        return commonResult;
    }

    public static CommonResult success(Object data){
        CommonResult commonResult = new CommonResult();
        commonResult.timestamp = LocalDateTime.now();
        commonResult.code = ResultCode.SUCCESS.code();
        commonResult.message = ResultCode.SUCCESS.message();
        commonResult.setData(data);
        return commonResult;
    }

    public static CommonResult error(ResultCode resultCode){
        CommonResult commonResult = new CommonResult();
        commonResult.timestamp = LocalDateTime.now();
        commonResult.code = resultCode.code();
        commonResult.message = resultCode.message();
        return commonResult;
    }

}
