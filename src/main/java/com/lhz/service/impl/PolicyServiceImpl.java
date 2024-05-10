package com.lhz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lhz.entity.Policy;
import com.lhz.mapper.PolicyMapper;
import com.lhz.service.PolicyService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 考研政策表(Policy)表服务实现类
 *
 * @author makejava
 * @since 2024-04-01 15:21:38
 */
@Service("policyService")
public class PolicyServiceImpl extends ServiceImpl<PolicyMapper, Policy> implements PolicyService {



    @Override
    public List<Policy> getPolicyInfoByType(String type, String schoolId) {
        List<Policy> list = null;
        if ("0".equals(type)){
            LambdaQueryWrapper<Policy> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(Policy::getType,type);
            list = list(queryWrapper);
        }else if ("1".equals(type)){
            LambdaQueryWrapper<Policy> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(Policy::getType,type);
            queryWrapper.eq(Policy::getSchoolId,schoolId);
            list = list(queryWrapper);
        }

        return list;
    }
}

