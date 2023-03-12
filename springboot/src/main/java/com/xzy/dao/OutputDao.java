package com.xzy.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xzy.domain.Output;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface OutputDao extends BaseMapper<Output> {

    //舆情热度相关方法
    @Select("SELECT created FROM output WHERE `user`=#{id} ORDER BY created LIMIT 1")
    String selectTimeFirst(Integer id);
    @Select("SELECT created FROM output WHERE `user`=#{id} ORDER BY created  desc LIMIT 1")
    String selectTimeEnd(Integer id);
    @Select("SELECT datediff(#{endTime},#{firstTime})")
    int getDay(String endTime,String firstTime);
    @Select("SELECT COUNT(*)+SUM(attitudes)+SUM(comments)+SUM(reposts) FROM output WHERE `user`=#{id}")
    int getHotNumber(Integer id);
    @Select("SELECT COUNT(*)+SUM(attitudes)+SUM(comments)+SUM(reposts) FROM output WHERE `user`=#{id} AND created BETWEEN #{firstTime} AND #{endTime}")
    int getHotNumberByTime(String endTime,String firstTime,Integer id);
}
