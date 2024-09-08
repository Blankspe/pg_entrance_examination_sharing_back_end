package com.lhz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lhz.entity.File;


/**
 * (File)表服务接口
 *
 * @author makejava
 * @since 2024-05-24 20:45:32
 */
public interface FileService extends IService<File> {

    File getFileByPostId(Integer postId);
}

