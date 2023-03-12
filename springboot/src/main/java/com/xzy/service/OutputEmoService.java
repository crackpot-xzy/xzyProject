package com.xzy.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xzy.controller.utils.R;
import com.xzy.domain.Output;

public interface OutputEmoService extends IService<Output> {

    R getAllEmo(Integer id);
    R getEmoByTime(String startTime,String endTime,Integer id);

}
