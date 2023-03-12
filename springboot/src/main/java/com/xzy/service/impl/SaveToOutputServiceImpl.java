package com.xzy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xzy.controller.utils.R;
import com.xzy.dao.InputDao;
import com.xzy.domain.Input;
import com.xzy.service.SaveToOutputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaveToOutputServiceImpl extends ServiceImpl<InputDao, Input> implements SaveToOutputService {
    @Autowired
    InputDao inputDao;
    @Override
    public R saveToOutput() {
        int i = inputDao.SaveToOutput();
        return new R(true,null,"成功保存"+i+"条记录");
    }
}
