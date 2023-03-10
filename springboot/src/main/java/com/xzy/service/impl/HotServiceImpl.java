package com.xzy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xzy.controller.utils.R;
import com.xzy.dao.InputDao;
import com.xzy.domain.Input;
import com.xzy.service.EmoService;
import com.xzy.service.HotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotServiceImpl extends ServiceImpl<InputDao, Input> implements HotService {

    @Autowired
    InputDao inputDao;
    @Override
    public R getAllHot() {
        try {
            String firstTime = inputDao.selectTimeFirst();
            String endTime = inputDao.selectTimeEnd();
            int day = inputDao.getDay(endTime,firstTime)+1;//+1保证不会出现/0的问题
            int hotnumber = inputDao.getHotNumber();
            Integer value = hotnumber/day;
            return new R(true,value,"全时间段热度计算成功");
        }catch (Exception e){
            return new R(true,null,"无数据");
        }

    }

    @Override
    public R getHotByTime(String startTime, String endTime) {
        try{
            int day = inputDao.getDay(endTime,startTime)+1;
            int hotnumber = inputDao.getHotNumberByTime(endTime,startTime);
            Integer value = hotnumber/day;
            return new R(true,value,"该时间段热度计算成功");
        }catch (Exception e){
            return new R(true,null,"无数据");
        }

    }
}
