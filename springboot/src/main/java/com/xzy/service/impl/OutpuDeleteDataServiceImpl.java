package com.xzy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xzy.controller.utils.R;
import com.xzy.dao.OutputDao;
import com.xzy.domain.Output;
import com.xzy.service.OutpuDeleteDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OutpuDeleteDataServiceImpl extends ServiceImpl<OutputDao, Output> implements OutpuDeleteDataService {

    @Autowired
    OutputDao outputDao;
    @Override
    public R Delete(String startTime, String endTime,Integer id) {
        QueryWrapper<Output> wrapper = new QueryWrapper<>();
        wrapper.between("created",startTime,endTime).eq("user",id);
        int r = outputDao.delete(wrapper);
        return new R(true,null,"成功删除"+r+"条数据");
    }
}
