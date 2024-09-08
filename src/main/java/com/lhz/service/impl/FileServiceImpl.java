package com.lhz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lhz.entity.File;
import com.lhz.mapper.FileMapper;
import com.lhz.service.FileService;
import io.minio.MinioClient;
import io.minio.errors.*;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * (File)表服务实现类
 *
 * @author makejava
 * @since 2024-05-24 20:45:32
 */
@Service("fileService")
public class FileServiceImpl extends ServiceImpl<FileMapper, File> implements FileService {

    @Override
    public File getFileByPostId(Integer postId) {
        LambdaQueryWrapper<File> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(File::getPostId , postId);
        File file = getOne(queryWrapper);

        // 创建 MinioClient 实例
        MinioClient minioClient = new MinioClient("http://192.168.200.138:19000",
                "minioadmin",
                "minioadmin");

        // 指定要生成预签名 URL 的桶名和对象名
        String bucketName = file.getBucketName();
        String objectName = file.getOriginalName();

        // 设置 URL 的过期时间（例如，600 秒）
        Integer expiration = 600;

        // 生成预签名的 GET URL
        String presignedUrl = null;
        try {
            presignedUrl = minioClient.presignedGetObject(bucketName, objectName, expiration);
        } catch (ErrorResponseException e) {
            throw new RuntimeException(e);
        } catch (InsufficientDataException e) {
            throw new RuntimeException(e);
        } catch (InternalException e) {
            throw new RuntimeException(e);
        } catch (InvalidBucketNameException e) {
            throw new RuntimeException(e);
        } catch (InvalidExpiresRangeException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeyException e) {
            throw new RuntimeException(e);
        } catch (InvalidResponseException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (ServerException e) {
            throw new RuntimeException(e);
        } catch (XmlParserException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Pre-signed URL: " + presignedUrl);

        file.setPath(presignedUrl);
        return file;
    }
}

