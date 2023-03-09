package com.xzy.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xzy.domain.DTO.SearchInputDto;
import com.xzy.domain.Input;
import org.apache.ibatis.annotations.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.List;

@Mapper
public interface InputDao extends BaseMapper<Input> {
    //从weibo表中导入input表中没有的数据
    @Insert("INSERT INTO input(input.id,input.text,input.location,input.attitudes,input.comments,input.reposts,input.created) \n" +
            "SELECT weibo.id,weibo.text,weibo.location,weibo.attitudes_count,weibo.comments_count,weibo.reposts_count,weibo.created_at FROM weibo WHERE NOT EXISTS(SELECT * FROM input WHERE input.id=weibo.id)")
    int SpiderToInput();

    @Insert("INSERT INTO input(input.id,input.text,input.attitudes,input.comments,input.reposts,input.created) VALUES (#{id},#{text},#{att},#{com},#{rep},#{tim})")
    int UserToInput(String text, String att, String com, String rep,String tim,String id);

    @Insert("INSERT INTO input(id,text,attitudes,comments,reposts,created,location) " +
            "VALUES(#{id},#{t},#{a},#{c},#{r},#{tim},#{l})")
    int FileToInput(String id,String t,Integer a,Integer c,Integer r,String tim,String l);

    @Delete("DELETE FROM input")
    int DeleteAll();

    //未输入时间条件返回全部数据 https://www.jb51.net/article/199123.htm (字段映射问题参考文章)
    //    @Result(column = "created_at",property = "created_at") 不符合驼峰命名方式时使用
    @Select("SELECT text,created FROM input LIMIT #{currentPage},#{pageSize}")
    List<SearchInputDto> selectAll(int currentPage,int pageSize);

    //根据时间查询记录条数
    //根据时间查询返回分页结果

}
