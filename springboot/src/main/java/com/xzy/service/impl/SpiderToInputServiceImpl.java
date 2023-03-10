package com.xzy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xzy.controller.utils.R;
import com.xzy.dao.InputDao;
import com.xzy.domain.Input;
import com.xzy.service.SpiderToInputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpiderToInputServiceImpl extends ServiceImpl<InputDao, Input> implements SpiderToInputService {

    @Autowired
    InputDao inputDao;
    @Override
    public R toInput() {
        int col = inputDao.SpiderToInput();
        return new R(true,null,"数据导入成功共导入"+col+"条数据");
    }
}
