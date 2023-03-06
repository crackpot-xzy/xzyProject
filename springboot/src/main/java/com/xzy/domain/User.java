package com.xzy.domain;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String name;
    private String password;
    private Integer account;
    private Integer privileges;
    private String address;
    private String email;
}
