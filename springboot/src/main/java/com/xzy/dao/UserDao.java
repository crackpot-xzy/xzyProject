package com.xzy.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xzy.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao extends BaseMapper<User> {
    //查询账号是否存在
    @Select("select id from User where account = #{account}")
    Integer selectByAccount(String account);
    //查询账号密码是否正确，并返回用户id
    @Select("select * from User where account = #{account} and password = #{password}")
    User selectByAccountPassword(String account,String password);
    @Insert("INSERT INTO `user`(`name`,account,`password`,`privileges`) VALUES ('default_userName',#{account},#{password},1)")
    Integer insertAccountPassword(String account,String password);
}
