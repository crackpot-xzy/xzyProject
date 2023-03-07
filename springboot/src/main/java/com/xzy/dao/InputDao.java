package com.xzy.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xzy.domain.Input;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;

@Mapper
public interface InputDao extends BaseMapper<Input> {
    //从weibo表中导入input表中没有的数据
    @Insert("INSERT INTO input(input.id,input.text,input.location,input.attitudes_count,input.comments_count,input.reposts_count,input.created_at) \n" +
            "SELECT weibo.id,weibo.text,weibo.location,weibo.attitudes_count,weibo.comments_count,weibo.reposts_count,weibo.created_at FROM weibo WHERE NOT EXISTS(SELECT * FROM input WHERE input.id=weibo.id)")
    int SpiderToInput();

    @Insert("INSERT INTO input(input.id,input.text,input.attitudes_count,input.comments_count,input.reposts_count,input.created_at) VALUES ('default_id',#{text},#{att},#{com},#{rep},#{tim})")
    int UserToInput(String text, String att, String com, String rep,String tim);
}
