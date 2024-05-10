package com.lhz.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lhz.entity.School;
import com.lhz.mapper.SchoolMapper;
import com.lhz.service.SchoolService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (School)表服务实现类
 *
 * @author makejava
 * @since 2024-04-08 11:17:35
 */
@Service("schoolService")
public class SchoolServiceImpl extends ServiceImpl<SchoolMapper, School> implements SchoolService {

    @Override
    public List<School> getSchools() {
        return list();
    }
}

