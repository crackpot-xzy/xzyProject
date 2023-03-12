package com.xzy.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xzy.domain.Output;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface OutputDao extends BaseMapper<Output> {

    //舆情热度相关方法
    @Select("SELECT created FROM output ORDER BY created LIMIT 1")
    String selectTimeFirst();
    @Select("SELECT created FROM output ORDER BY created  desc LIMIT 1")
    String selectTimeEnd();
    @Select("SELECT datediff(#{endTime},#{firstTime})")
    int getDay(String endTime,String firstTime);
    @Select("SELECT COUNT(*)+SUM(attitudes)+SUM(comments)+SUM(reposts) FROM output")
    int getHotNumber();
    @Select("SELECT COUNT(*)+SUM(attitudes)+SUM(comments)+SUM(reposts) FROM output WHERE created BETWEEN #{firstTime} AND #{endTime}")
    int getHotNumberByTime(String endTime,String firstTime);
}
