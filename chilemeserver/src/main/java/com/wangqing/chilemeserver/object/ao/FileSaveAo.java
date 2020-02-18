package com.wangqing.chilemeserver.object.ao;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FileSaveAo {
    Integer userId;
    String fileUrl;
    String type;
}
