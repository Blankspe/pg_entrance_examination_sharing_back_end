package com.lhz.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lhz.entity.Category;
import com.lhz.mapper.CategoryMapper;
import com.lhz.service.CategoryService;
import org.springframework.stereotype.Service;

/**
 * 标签枚举(Category)表服务实现类
 *
 * @author makejava
 * @since 2024-04-22 14:44:35
 */
@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

}

