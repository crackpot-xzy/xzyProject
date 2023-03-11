package com.xzy.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xzy.controller.utils.R;
import com.xzy.domain.Input;

import java.util.Map;

public interface HotService extends IService<Input> {

    R getAllHot();
    R getHotByTime(String startTime,String endTime);

}
