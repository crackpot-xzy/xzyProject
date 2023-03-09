package com.xzy.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "input")
public class Input {
    private String id;
    private Integer user;//所属用户id，用于output
    private String text;
    private String location;
    private String created;//时间类型
    private String edit;//时间类型
    private Integer attitudes;//点赞
    private Integer comments;//评论
    private Integer reposts;//转发
    private Integer emo;
}
