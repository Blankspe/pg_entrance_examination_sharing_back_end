package com.lhz.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lhz.entity.File;
import com.lhz.entity.Post;
import com.lhz.entity.TestDTO;
import com.lhz.entity.User;
import com.lhz.entity.dto.UserUpdateDTO;
import com.lhz.response.BaseResponse;
import com.lhz.service.FileService;
import com.lhz.service.PostService;
import com.lhz.service.UserService;
import io.minio.*;
import io.minio.errors.*;
import io.minio.http.Method;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Timer;

@RestController
@RequestMapping
public class TestController {
    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;

    @Autowired
    private FileService fileService;

//    @Value("${data}")
//    public String string;

    @GetMapping("/test1")
    public BaseResponse<User> test1(){
        return BaseResponse.success(userService.getById(1));
    }

    /*@GetMapping("/test")
    public String test(){
        return string;
    }*/

    @GetMapping("user")
    public User user(){
        return new User("小明");
    }

    @GetMapping("/testRedirect")
    public void testRedirect(HttpServletResponse response) throws IOException {
        /*BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("D://iotest//"+fileName));

        byte[] bytes = new byte[1024*1024*50];
        int len = bis.read(bytes);
        while(len !=-1){
            bos.write(bytes,0,len);
            len = bis.read(bytes);
        }*/
        response.sendRedirect("http://localhost:8080/test");
    }

    @PostMapping("/fileUpLoad")
    public void fileUpLoad(@RequestBody MultipartFile file, @RequestHeader String postId) throws IOException, ServerException, InsufficientDataException, ErrorResponseException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException, InvalidBucketNameException, RegionConflictException, InvalidExpiresRangeException {
        //文件输入流
        BufferedInputStream bis = new BufferedInputStream(file.getInputStream());
        String fileName = file.getOriginalFilename();
        //minio端信息，建立客户端
        String endPoint = "http://192.168.200.138:19000";
        String bucketName = "files";
        String contentType = file.getContentType();
        System.out.println(contentType);
        MinioClient minioClient = MinioClient.builder()
                .endpoint(endPoint)
                .credentials("minioadmin","minioadmin")
                .build();
        //文件参数
        PutObjectArgs putObjectArgs = PutObjectArgs.builder()
                        .stream(bis, bis.available(), -1)
                        .object(fileName)
                        .contentType(contentType)
                                .bucket(bucketName).build();
        boolean bucketExists = minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
        if (bucketExists == true){

        }else{
            minioClient.makeBucket(bucketName);
        }
        minioClient.putObject(putObjectArgs);
        String url = endPoint+"/"+bucketName+"/"+fileName;

        System.out.println(url);
        File fileDO = new File();
        fileDO.setPath(url);
        fileDO.setOriginalName(fileName);
        fileDO.setBucketName(bucketName);
        fileDO.setPostId(Integer.valueOf(postId));
        fileService.save(fileDO);

    }

    @PostMapping("update")
    public BaseResponse<String> update(@RequestBody @Validated UserUpdateDTO userDTO){
        User user = new User();
        BeanUtils.copyProperties(userDTO,user);
        boolean b = userService.updateById(user);
        System.out.println(b);
        return BaseResponse.success("success");
    }
}
