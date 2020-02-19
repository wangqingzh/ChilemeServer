package com.wangqing.chilemeserver.object.dto;

import com.wangqing.chilemeserver.object.ao.UploadFileType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class UploadFileDto {
    private UploadFileType type;
    private Integer id;
}
