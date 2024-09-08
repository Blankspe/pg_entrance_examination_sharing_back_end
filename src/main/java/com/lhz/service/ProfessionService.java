package com.lhz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lhz.entity.Profession;

import java.util.List;


/**
 * (Profession)表服务接口
 *
 * @author makejava
 * @since 2024-05-23 07:38:03
 */
public interface ProfessionService extends IService<Profession> {

    List<Profession> getProfessionList();

    List<Profession> getProfessionByName(String name);

    List<Profession> getDistinctList();
}

