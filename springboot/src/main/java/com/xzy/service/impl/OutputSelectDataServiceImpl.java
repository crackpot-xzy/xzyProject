package com.xzy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xzy.controller.utils.R;
import com.xzy.dao.OutputDao;
import com.xzy.domain.Output;
import com.xzy.service.OutputSelectDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OutputSelectDataServiceImpl extends ServiceImpl<OutputDao,Output> implements OutputSelectDataService {
    @Autowired
    OutputDao outputDao;

    @Override
    public R SelectDataByTime(int currentPage, int pageSize, String startTime, String endTime,Integer id) {
        QueryWrapper<Output> wrapper = new QueryWrapper<>();
        wrapper.between("created",startTime,endTime).eq("user",id);
        IPage<Output> page = new Page<>(currentPage,pageSize);
        outputDao.selectPage(page,wrapper);
        return new R(true,page,"查询成功");
    }

    @Override
    public R SelectAllData(int currentPage, int pageSize,Integer id) {
        QueryWrapper<Output> wrapper = new QueryWrapper<>();
        wrapper.eq("user",id);
        IPage<Output> page = new Page<>(currentPage,pageSize);
        outputDao.selectPage(page,wrapper);
        return new R(true,page,"查询成功");
    }
}
