package com.xzy.domain.DTO;

import lombok.Data;

import java.util.Date;

@Data
public class UserInputDto {
    private String text;
    private String attitudes;
    private String comments;
    private String reposts;
    private String time;
    private String id;
}
