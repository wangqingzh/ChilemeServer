package com.wangqing.chilemeserver.service;

import com.wangqing.chilemeserver.object.dto.UploadFileDto;
import com.wangqing.chilemeserver.repository.PostRepository;
import com.wangqing.chilemeserver.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 文件相关的服务
 */

@Service
public class FileService {
    @Autowired
    UserInfoRepository userInfoRepository;

    @Autowired
    PostRepository postRepository;


    public void saveFileUrl(UploadFileDto uploadFileDto,String fileUrl) {
        Integer typeCode = uploadFileDto.getTypeCode();
        Integer id = uploadFileDto.getId();

        switch (typeCode){
            case UploadFileDto.USER_AVATAR:
                userInfoRepository.updateAvatarUrlByUserId(fileUrl, id);
                break;
            case UploadFileDto.USER_COVER:
                userInfoRepository.updateCoverUrlByUserId(fileUrl, id);
                break;
            case UploadFileDto.FOOD_REC_IMAGE:
            case UploadFileDto.EVALUATION_IMAGE:
                postRepository.updateImageUrlByPostId(fileUrl, id);
                break;
            default:
                break;
        }
    }
}
