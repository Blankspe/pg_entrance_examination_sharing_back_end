package com.lhz.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lhz.entity.Profession;
import com.lhz.mapper.ProfessionMapper;
import com.lhz.service.ProfessionService;
import org.springframework.stereotype.Service;

/**
 * (Profession)表服务实现类
 *
 * @author makejava
 * @since 2024-05-23 07:38:03
 */
@Service("professionService")
public class ProfessionServiceImpl extends ServiceImpl<ProfessionMapper, Profession> implements ProfessionService {

}

