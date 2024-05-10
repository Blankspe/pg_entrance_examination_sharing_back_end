package com.lhz.controller;

import com.lhz.entity.Policy;
import com.lhz.response.BaseResponse;
import com.lhz.service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 考研政策表(Policy)表控制层
 *
 * @author makejava
 * @since 2024-04-01 15:21:57
 */
@RestController
@RequestMapping
public class PolicyController  {

    @Autowired
    private PolicyService policyService;

    @PostMapping("/getPolicyInfo")
    public BaseResponse<List<Policy>> getPolicyInfoByType(String type,String schoolId){
        return BaseResponse.success(policyService.getPolicyInfoByType(type,schoolId));
    }

}

