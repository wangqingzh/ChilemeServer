package com.wangqing.chilemeserver.service;

import com.wangqing.chilemeserver.object.ao.FileSaveAo;
import com.wangqing.chilemeserver.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * 文件相关的服务
 */

@Service
public class FileService {
    @Autowired
    UserInfoRepository userInfoRepository;


    public void saveFileUrl(FileSaveAo fileSaveAo) {
        String type = fileSaveAo.getType();
        Integer userId = fileSaveAo.getUserId();
        String fileUrl = fileSaveAo.getFileUrl();
        if (type.equals("avatar")) {
            userInfoRepository.updateAvatarUrlByUserId(fileUrl, userId);
        } else if (type.equals("cover")) {
            userInfoRepository.updateCoverUrlByUserId(fileUrl, userId);
        }
    }
}
