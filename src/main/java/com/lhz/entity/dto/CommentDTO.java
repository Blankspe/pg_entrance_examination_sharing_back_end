package com.lhz.entity.dto;

import com.lhz.entity.Comment;
import lombok.Data;

@Data
public class CommentDTO extends Comment {
    private String userName;
    private Integer allScore;
    private String school;
    private String targetSchool;
    private String profilePict;
}
