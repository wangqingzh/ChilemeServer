package com.wangqing.chilemeserver.object.ao;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    /* 响应状态码 */
    private Integer status;
    /* 错误原因 */
    private String error;
    /* 异常信息 */
    private String message;
    /* 异常堆栈 */
    private String trace;

    public static final class ApiErrorResponseBuilder {
        /* 时间戳 */
        private LocalDateTime timestamp;
        /* 响应状态码 */
        private Integer status;
        /* 错误原因 */
        private String error;
        /* 异常信息 */
        private String message;
        /* 异常堆栈 */
        private String trace;


        public ApiErrorResponseBuilder() {
            this.timestamp = LocalDateTime.now();
        }

        public static ApiErrorResponseBuilder anApiErrorResponse() {
            return new ApiErrorResponseBuilder();
        }

        public ApiErrorResponseBuilder withStatus(Integer status) {
            this.status = status;
            return this;
        }

        public ApiErrorResponseBuilder withError(String error) {
            this.error = error;
            return this;
        }

        public ApiErrorResponseBuilder withMessage(String message) {
            this.message = message;
            return this;
        }

        public ApiErrorResponseBuilder withTrace(String trace) {
            this.trace = trace;
            return this;
        }

    public ApiErrorResponse build() {
        ApiErrorResponse apiErrorResponse = new ApiErrorResponse();
        apiErrorResponse.timestamp = this.timestamp;
        apiErrorResponse.status = this.status;
        apiErrorResponse.error = this.error;
        apiErrorResponse.message = this.message;
        apiErrorResponse.trace = this.trace;
        return apiErrorResponse;
    }
}


}
