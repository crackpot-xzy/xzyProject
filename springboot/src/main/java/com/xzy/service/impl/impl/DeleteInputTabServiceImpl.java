package com.xzy.service.impl.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xzy.controller.utils.R;
import com.xzy.dao.InputDao;
import com.xzy.domain.Input;
import com.xzy.service.impl.DeleteInputTabService;
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
}
