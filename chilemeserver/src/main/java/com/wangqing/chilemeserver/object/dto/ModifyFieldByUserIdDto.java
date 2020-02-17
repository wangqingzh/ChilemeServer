package com.wangqing.chilemeserver.object.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ModifyFieldByUserIdDto {
    Integer userId;
    String field;
}
