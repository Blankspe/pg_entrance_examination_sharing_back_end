package com.lhz.controller;

import com.lhz.entity.File;
import com.lhz.response.BaseResponse;
import com.lhz.service.FileService;
import com.lhz.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/file")
public class FileController {
    @Autowired
    private FileService fileService;
    @RequestMapping("/getFileByPostId")
    public BaseResponse<File> getFileByPostId(Integer postId){
        return BaseResponse.success(fileService.getFileByPostId(postId));
    }
}
