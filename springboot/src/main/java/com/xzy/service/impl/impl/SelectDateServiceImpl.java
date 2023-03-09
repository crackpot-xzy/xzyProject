package com.xzy.service.impl.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xzy.controller.utils.R;
import com.xzy.dao.InputDao;
import com.xzy.domain.Input;
import com.xzy.service.impl.SelectDateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SelectDateServiceImpl extends ServiceImpl<InputDao, Input> implements SelectDateService {

    @Autowired
    InputDao inputDao;


    @Override
    public R SelectDateByTime(int currentPage, int pageSize, String startTime, String endTime) {
        QueryWrapper<Input> wrapper = new QueryWrapper<>();
        wrapper.between("created",startTime,endTime);
        IPage<Input> page = new Page<>(currentPage,pageSize);
        inputDao.selectPage(page,wrapper);
        return new R(true,page,"查询成功");
    }

    @Override
    public R SelectAllDate(int currentPage, int pageSize) {
        IPage<Input> page = new Page<>(currentPage,pageSize);
        inputDao.selectPage(page,null);
        return new R(true,page,"查询成功");
    }
}
