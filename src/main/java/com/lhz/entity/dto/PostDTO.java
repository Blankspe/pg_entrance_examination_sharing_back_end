package com.lhz.entity.dto;

import com.lhz.entity.Post;
import lombok.Data;

@Data
public class PostDTO extends Post {
    private String userName;
    private Integer allScore;
    private String school;
    private String targetSchool;
    private String profilePict;
}
