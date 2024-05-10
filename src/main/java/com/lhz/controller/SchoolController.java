package com.lhz.controller;

import com.lhz.entity.School;
import com.lhz.response.BaseResponse;
import com.lhz.service.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class SchoolController {

    private final SchoolService schoolService;

    @GetMapping("/getSchools")
    public BaseResponse<List<School>> getSchools(){
        return BaseResponse.success(schoolService.getSchools()) ;
    }
}
