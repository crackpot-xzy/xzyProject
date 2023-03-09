package com.xzy.domain.DTO;

import lombok.Data;

import java.sql.Timestamp;


@Data
public class SearchInputDto {
    private String text;
    private String created;
}
