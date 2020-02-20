package com.wangqing.chilemeserver.web.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wangqing.chilemeserver.object.ao.CommonResult;
import com.wangqing.chilemeserver.object.dto.UploadFileDto;
import com.wangqing.chilemeserver.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * 头像 与 封面 图片的上传与下载接口
 */
@RestController
public class FileApi {
    @Autowired
    private FileService fileService;

    @Value("${file-path}")
    private String filePath;

    @Value("${image-path}")
    String imagePath;

    @PostMapping("/file/upload")
    public HttpEntity<?> uploadFile(@RequestParam("file") MultipartFile uploadFile, @RequestParam("upInfo") String upInfo){
        UploadFileDto uploadFileDto = null;
        try {
            uploadFileDto = new ObjectMapper().readValue(upInfo, UploadFileDto.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(uploadFileDto);
        File folder = new File(filePath); //文件保存目录
        if (!folder.isDirectory()){
            folder.mkdirs();
        }
        String oldName = uploadFile.getOriginalFilename();
        String newName = UUID.randomUUID().toString() + oldName.substring(oldName.lastIndexOf("."), oldName.length());
        try {
            uploadFile.transferTo(new File(folder, newName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        fileService.saveFileUrl(uploadFileDto, "image/" + newName); // 将文件路径持久化到数据库
        return new ResponseEntity<>(CommonResult.success(), HttpStatus.OK);
    }
}
