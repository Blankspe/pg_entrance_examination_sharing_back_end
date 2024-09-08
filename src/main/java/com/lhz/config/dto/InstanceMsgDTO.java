package com.lhz.config.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InstanceMsgDTO {
    private Integer senderId;
    private Integer receiverId;
    private String msg;
}
