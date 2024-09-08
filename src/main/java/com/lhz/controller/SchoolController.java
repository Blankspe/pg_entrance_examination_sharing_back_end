package com.lhz.controller;

import com.lhz.entity.School;
import com.lhz.entity.dto.SchoolInfoDTO;
import com.lhz.response.BaseResponse;
import com.lhz.service.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/getSchoolByInfo")
    public BaseResponse<List<School>> getSchoolByInfo(@RequestBody SchoolInfoDTO schoolInfoDTO){
        return BaseResponse.success(schoolService.getSchoolByInfo(schoolInfoDTO));
    }
}
