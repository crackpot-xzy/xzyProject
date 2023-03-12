package com.xzy.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xzy.controller.utils.R;
import com.xzy.domain.Output;

public interface OutpuDeleteDataService extends IService<Output> {
    R Delete(String startTime,String endTime);
}
