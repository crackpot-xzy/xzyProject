package com.xzy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xzy.controller.utils.R;
import com.xzy.dao.InputDao;
import com.xzy.dao.OutputDao;
import com.xzy.domain.Input;
import com.xzy.domain.Output;
import com.xzy.service.HotService;
import com.xzy.service.OutputHotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OutputHotServiceImpl extends ServiceImpl<OutputDao, Output> implements OutputHotService {

    @Autowired
    OutputDao outputDao;

    @Override
    public R getAllHot() {
        String firstTime = outputDao.selectTimeFirst();
        String endTime = outputDao.selectTimeEnd();
        int day = outputDao.getDay(endTime,firstTime)+1;//+1保证不会出现/0的问题
        int hotnumber = outputDao.getHotNumber();
        Integer value = hotnumber/day;
        return new R(true,value,"全时间段热度计算成功");
    }

    @Override
    public R getHotByTime(String startTime, String endTime) {
        int day = outputDao.getDay(endTime,startTime)+1;
        int hotnumber = outputDao.getHotNumberByTime(endTime,startTime);
        Integer value = hotnumber/day;
        return new R(true,value,"该时间段热度计算成功");
    }
}
