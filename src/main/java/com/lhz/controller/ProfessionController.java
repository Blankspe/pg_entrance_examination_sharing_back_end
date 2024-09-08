package com.lhz.controller;

import com.lhz.entity.Profession;
import com.lhz.response.BaseResponse;
import com.lhz.service.ProfessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/profession")
public class ProfessionController {
    @Autowired
    private ProfessionService professionService;
    @PostMapping("/getAllProfessions")
    public BaseResponse<List<Profession>> getAllProfessions(){
        return BaseResponse.success(professionService.getProfessionList());
    }

    @PostMapping("/getAllProfession")
    public BaseResponse<List<Profession>> getAllProfession(){
        return BaseResponse.success(professionService.getDistinctList());
    }

    @PostMapping("/getProfessionByName")
    public BaseResponse<List<Profession>> getProfessionByName(String name){
        return BaseResponse.success(professionService.getProfessionByName(name));
    }
}
