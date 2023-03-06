package com.xzy.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xzy.domain.Table;
import com.xzy.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TableDao extends BaseMapper<Table> {

}
