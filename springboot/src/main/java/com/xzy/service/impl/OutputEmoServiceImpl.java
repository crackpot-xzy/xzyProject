package com.xzy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xzy.controller.utils.R;
import com.xzy.dao.OutputDao;
import com.xzy.domain.Output;
import com.xzy.service.OutputEmoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class OutputEmoServiceImpl extends ServiceImpl<OutputDao, Output> implements OutputEmoService {

    @Autowired
    OutputDao outputDao;
    @Override
    public R getAllEmo(Integer id) {
        List list = new ArrayList<>();
        int good=0;int neu=0;int bad=0;
        QueryWrapper<Output> wrapper = new QueryWrapper<>();
        wrapper.eq("user",id).eq("emo",0);
        neu = outputDao.selectCount(wrapper);
        QueryWrapper<Output> wrapper2 = new QueryWrapper<>();
        wrapper2.eq("user",id).eq("emo",1);
        good = outputDao.selectCount(wrapper2);
        QueryWrapper<Output> wrapper3 = new QueryWrapper<>();
        wrapper3.eq("user",id).eq("emo",-1);
        bad = outputDao.selectCount(wrapper3);
        list.add(good);list.add(neu);list.add(bad);
        return new R(true,list,"全部数据情感分析成功");
    }

    @Override
    public R getEmoByTime(String startTime, String endTime,Integer id) {
        List list = new ArrayList<>();
        int good=0;int neu=0;int bad=0;
        QueryWrapper<Output> wrapper = new QueryWrapper<>();
        wrapper.between("created",startTime,endTime).eq("user",id).eq("emo",0);
        neu = outputDao.selectCount(wrapper);
        QueryWrapper<Output> wrapper2 = new QueryWrapper<>();
        wrapper2.between("created",startTime,endTime).eq("user",id).eq("emo",1);
        good = outputDao.selectCount(wrapper2);
        QueryWrapper<Output> wrapper3 = new QueryWrapper<>();
        wrapper3.between("created",startTime,endTime).eq("user",id).eq("emo",-1);
        bad = outputDao.selectCount(wrapper3);

        list.add(good);list.add(neu);list.add(bad);
        return new R(true,list,"该时间段数据情感分析成功");
    }
}
