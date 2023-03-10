package com.xzy.domain.DTO;

import lombok.Data;

@Data
public class NameValueDto implements Comparable<NameValueDto>{
    String name;
    Integer value;

    @Override
    public int compareTo(NameValueDto nameValueDto) {
        return nameValueDto.getValue()-this.getValue();
    }
}
