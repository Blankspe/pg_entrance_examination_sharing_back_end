package com.lhz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lhz.entity.Policy;

import java.util.List;


/**
 * 考研政策表(Policy)表服务接口
 *
 * @author makejava
 * @since 2024-04-01 15:21:38
 */
public interface PolicyService extends IService<Policy> {

    List<Policy> getPolicyInfoByType(String type, String schoolId);
}

