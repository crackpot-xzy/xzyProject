package com.xzy.service.impl.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xzy.controller.utils.R;
import com.xzy.dao.InputDao;
import com.xzy.domain.DTO.TimeDto;
import com.xzy.domain.Input;
import com.xzy.service.impl.SelectDateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SelectDateServiceImpl extends ServiceImpl<InputDao, Input> implements SelectDateService {

    @Autowired
    InputDao inputDao;

    @Override
    public R selectDate(TimeDto timeDto) {

        return null;
    }
}
