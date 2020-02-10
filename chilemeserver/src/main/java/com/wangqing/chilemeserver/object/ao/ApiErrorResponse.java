package com.wangqing.chilemeserver.object.ao;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

/**
 * WEB API接口捕捉到异常后的返回信息封装 参考springboot 默认错误返回信息
 */
@Data
public class ApiErrorResponse {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    /* 时间戳 */
    private LocalDateTime timestamp;
    /* 响应状态 */
    @JsonIgnore
    private HttpStatus httpStatus;
    /* 响应状态码 */
    private Integer status;
    /* 错误原因 */
    private String error;
    /* 异常信息 */
    private String message;


    public static final class ApiErrorResponseBuilder {
        /* 时间戳 */
        private LocalDateTime timestamp;
        /* 响应状态 */
        private HttpStatus httpStatus;
        /* 响应状态码 */
        private Integer status;
        /* 错误原因 */
        private String error;
        /* 异常信息 */
        private String message;

        public ApiErrorResponseBuilder() {
            this.timestamp = LocalDateTime.now();
        }

        public ApiErrorResponseBuilder withHttpStatus(HttpStatus httpStatus) {
            this.httpStatus = httpStatus;
            return this;
        }

        public ApiErrorResponseBuilder withMessage(String message) {
            this.message = message;
            return this;
        }

        public ApiErrorResponse build() {
            ApiErrorResponse apiErrorResponse = new ApiErrorResponse();
            apiErrorResponse.httpStatus = this.httpStatus;
            apiErrorResponse.timestamp = this.timestamp;
            apiErrorResponse.status = this.httpStatus.value();
            apiErrorResponse.error = this.httpStatus.getReasonPhrase();
            apiErrorResponse.message = this.message;
            return apiErrorResponse;
        }
    }


}
