package com.lhz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lhz.entity.School;
import com.lhz.entity.dto.SchoolInfoDTO;

import java.util.List;


/**
 * (School)表服务接口
 *
 * @author makejava
 * @since 2024-04-08 11:17:35
 */
public interface SchoolService extends IService<School> {

    List<School> getSchools();

    List<School> getSchoolByInfo(SchoolInfoDTO schoolInfoDTO);
}

