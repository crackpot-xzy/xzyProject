package com.xzy.service.impl.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xzy.controller.utils.R;
import com.xzy.dao.InputDao;
import com.xzy.domain.DTO.SearchInputDto;
import com.xzy.domain.Input;
import com.xzy.service.impl.SelectDateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SelectDateServiceImpl extends ServiceImpl<InputDao, Input> implements SelectDateService {

    @Autowired
    InputDao inputDao;


    @Override
    public R SelectDateByTime(int currentPage, int pageSize, String startTime, String endTime) {
        return null;
    }

    @Override
    public R SelectAllDate(int currentPage, int pageSize) {
        IPage<Input> page = new Page<>(currentPage,pageSize);
        inputDao.selectPage(page,null);
        return new R(true,page,"查询成功");
    }
}
