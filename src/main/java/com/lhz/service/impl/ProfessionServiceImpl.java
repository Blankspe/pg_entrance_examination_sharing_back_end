package com.lhz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lhz.entity.Profession;
import com.lhz.mapper.ProfessionMapper;
import com.lhz.service.ProfessionService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (Profession)表服务实现类
 *
 * @author makejava
 * @since 2024-05-23 07:38:03
 */
@Service("professionService")
public class ProfessionServiceImpl extends ServiceImpl<ProfessionMapper, Profession> implements ProfessionService {

    @Override
    public List<Profession> getProfessionList() {
        QueryWrapper queryWrapper = new QueryWrapper();
//        queryWrapper.select("distinct school_name,school_link");
        queryWrapper.last("limit 200");
        List<Profession> list = list(queryWrapper);

        return list;
    }

    @Override
    public List<Profession> getProfessionByName(String name) {
        LambdaQueryWrapper<Profession> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Profession::getSchoolName,name);
        queryWrapper.last("LIMIT 500");
        List<Profession> list = list(queryWrapper);
        return list;
    }

    @Override
    public List<Profession> getDistinctList() {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.select("distinct school_name,school_link");
//        queryWrapper.last("limit 200");
        List<Profession> list = list(queryWrapper);

        return list;
    }
}

