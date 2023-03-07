package com.xzy.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Date;

@Data
@TableName(value = "input")
public class Input {
    private String id;
    private String user_id;//所属用户id，用于output
    private String text;
    private String location;
    private Date created_at;//时间类型
    private Date edit_at;//时间类型
    private Integer attitudes_count;//点赞
    private Integer comments_count;//评论
    private Integer reposts_count;//转发
    private Integer emo;
}
