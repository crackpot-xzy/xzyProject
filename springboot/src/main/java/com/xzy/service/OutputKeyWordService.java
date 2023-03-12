package com.xzy.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xzy.controller.utils.R;
import com.xzy.domain.Output;


public interface OutputKeyWordService extends IService<Output> {
    R getAllKeyWords();
    R getKeyWordsByTime(String startTime,String endTime);
}
