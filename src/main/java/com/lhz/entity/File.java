package com.lhz.entity;


import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * (File)表实体类
 *
 * @author makejava
 * @since 2024-05-24 20:45:32
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("file")
public class File  {
//主键@TableId
    @TableId(type = IdType.AUTO)
    private Integer fileId;

    private String bucketName;
//文件原名
    private String originalName;
//文件储存路径
    private String path;
//关联的帖子id
    private Integer postId;
//上传用户的id
    private Integer userId;



}

