package com.xzy.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Date;

@Data
@TableName(value = "table_1")
public class Table {
    private String id;
    private String bid;
    private String user_id;
    private String screen_name;
    private String text;
    private String article_url;
    private String topics;
    private String at_users;
    private String pics;
    private String video_url;
    private String location;
    private String retweet_id;
    private String source;
    private Date created_at;//时间类型
    private Integer attitudes_count;
    private Integer comments_count;
    private Integer reposts_count;
    private Integer emo;


}
