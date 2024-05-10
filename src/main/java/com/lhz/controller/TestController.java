package com.lhz.controller;

import com.lhz.entity.TestDTO;
import com.lhz.entity.User;
import com.lhz.entity.dto.UserUpdateDTO;
import com.lhz.response.BaseResponse;
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
import java.util.Timer;

@RestController
@RequestMapping
public class TestController {
    @Autowired
    private UserService userService;

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
        response.sendRedirect("http://localhost:8080/test");
    }

    @PostMapping("/fileUpLoad")
    public void fileUpLoad(@RequestBody MultipartFile file,TestDTO dto) throws IOException, ServerException, InsufficientDataException, ErrorResponseException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException, InvalidBucketNameException, RegionConflictException, InvalidExpiresRangeException {
        System.out.println(dto.getStr());
        System.out.println(dto.getNum());

        BufferedInputStream bis = new BufferedInputStream(file.getInputStream());


        String fileName = file.getOriginalFilename();

        /*BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("D://iotest//"+fileName));

        byte[] bytes = new byte[1024*1024*50];
        int len = bis.read(bytes);
        while(len !=-1){
            bos.write(bytes,0,len);
            len = bis.read(bytes);
        }*/

        String endPoint = "http://192.168.200.128:19000";
        String bucketName = "headimages";
        String contentType = file.getContentType();
        System.out.println(contentType);
        MinioClient minioClient = MinioClient.builder()
                .endpoint(endPoint)
                .credentials("minioadmin","minioadmin")
                .build();
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
        /*String objectUrl = minioClient.getPresignedObjectUrl(
                GetPresignedObjectUrlArgs.builder()
                        .bucket(bucketName)
                        .object(fileName)
                        .build()
        );*/
        String objectUrl1 = minioClient.getObjectUrl(bucketName, fileName);

        String url = endPoint+"/"+bucketName+"/"+fileName;

        System.out.println(url);
//        System.out.println(objectUrl);
        System.out.println("最后一个"+objectUrl1);
        Timer timer = new Timer();

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
