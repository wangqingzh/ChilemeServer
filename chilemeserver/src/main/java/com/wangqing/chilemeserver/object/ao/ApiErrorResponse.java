package com.wangqing.chilemeserver.object.ao;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

/**
 * WEB API接口捕捉到异常后的返回信息封装
 */
@Data
public class ApiErrorResponse {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    /* 时间戳 */
    private LocalDateTime timestamp;
    /* 响应状态 */
    private HttpStatus status;
    /* 内部错误码 */
    private Integer error_code;
    /* 错误信息 */
    private String message;
    /* 详细信息 */
    private String detail;

    public static final class ApiErrorResponseBuilder {
        private LocalDateTime timestamp;
        private HttpStatus status;
        private Integer error_code;
        private String message;
        private String detail;

        public ApiErrorResponseBuilder() {
            this.timestamp = LocalDateTime.now();
        }

        public static ApiErrorResponseBuilder anApiErrorResponse() {
            return new ApiErrorResponseBuilder();
        }

        public ApiErrorResponseBuilder withStatus(HttpStatus status) {
            this.status = status;
            return this;
        }

        public ApiErrorResponseBuilder withError_code(Integer error_code) {
            this.error_code = error_code;
            return this;
        }

        public ApiErrorResponseBuilder withMessage(String message) {
            this.message = message;
            return this;
        }

        public ApiErrorResponseBuilder withDetail(String detail) {
            this.detail = detail;
            return this;
        }

    public ApiErrorResponse build() {
        ApiErrorResponse apiErrorResponse = new ApiErrorResponse();
        apiErrorResponse.timestamp = this.timestamp;
        apiErrorResponse.status = this.status;
        apiErrorResponse.error_code = this.error_code;
        apiErrorResponse.message = this.message;
        apiErrorResponse.detail = this.detail;
        return apiErrorResponse;
    }
}


}
