package com.xzy.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xzy.controller.utils.R;
import com.xzy.domain.Input;

public interface SelectDateService extends IService<Input> {
    R SelectDateByTime(int currentPage,int pageSize,String startTime,String endTime);
    R SelectAllDate(int currentPage,int pageSize);
}
