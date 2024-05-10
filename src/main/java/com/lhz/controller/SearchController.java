package com.lhz.controller;

import com.lhz.entity.Post;
import com.lhz.entity.dto.PostDTO;
import com.lhz.entity.dto.PostSearchDTO;
import com.lhz.response.BaseResponse;
import com.lhz.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/search")
@RequiredArgsConstructor
public class SearchController {

    private final PostService postService;

    @PostMapping("/postSearch")
    public BaseResponse<List<PostDTO>> postSearch(@RequestBody PostSearchDTO dto){
        return BaseResponse.success(postService.postSearch(dto.getVaguePost()));
    }

}
