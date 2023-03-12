package com.xzy.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xzy.controller.utils.R;
import com.xzy.domain.Output;

public interface OutputHotService extends IService<Output> {

    R getAllHot(Integer id);
    R getHotByTime(String startTime,String endTime,Integer id);

}
