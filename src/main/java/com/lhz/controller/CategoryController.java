package com.lhz.controller;

import com.lhz.entity.Category;
import com.lhz.response.BaseResponse;
import com.lhz.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/getCategoryList")
    public BaseResponse<List<Category>> getCategoryList(){
        List<Category> categories = categoryService.list();
        return BaseResponse.success(categories);
    }

    @PostMapping("/getCategoryNameById")
    public BaseResponse<String> getCategoryNameById(String categoryId){
        Category category = categoryService.getById(categoryId);
        if (Objects.isNull(category)){
            return BaseResponse.success();
        }
        String tagName = category.getTagName();
        return BaseResponse.success(tagName);
    }
}
