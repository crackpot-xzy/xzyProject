package com.xzy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xzy.controller.utils.R;
import com.xzy.dao.InputDao;
import com.xzy.domain.Input;
import com.xzy.domain.Output;
import com.xzy.service.DeleteInputTabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteInputTabServiceImpl extends ServiceImpl<InputDao,Input> implements DeleteInputTabService {

    @Autowired
    InputDao inputDao;

    @Override
    public R Delete() {
        int r = inputDao.DeleteAll();
        return new R(true,null,"共删除"+r+"条数据");
    }
    @Override
    public R Delete(String startTime, String endTime) {
        QueryWrapper<Input> wrapper = new QueryWrapper<>();
        wrapper.between("created",startTime,endTime);
        int r = inputDao.delete(wrapper);
        return new R(true,null,"成功删除"+r+"条数据");
    }
}
