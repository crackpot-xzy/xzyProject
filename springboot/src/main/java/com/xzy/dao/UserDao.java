package com.xzy.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xzy.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao extends BaseMapper<User> {
    @Select("select * from User where account = #{account} and password = #{password}")
    Integer selectByAccount(Integer account,String password);
}
