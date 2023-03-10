package com.xzy.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xzy.controller.utils.R;
import com.xzy.domain.Input;

public interface EmoService extends IService<Input> {

    R getAllEmo(Integer id);
    R getEmoByTime(String startTime,String endTime,Integer id);

}
