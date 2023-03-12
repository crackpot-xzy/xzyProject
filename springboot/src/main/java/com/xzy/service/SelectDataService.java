package com.xzy.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xzy.controller.utils.R;
import com.xzy.domain.Input;

public interface SelectDataService extends IService<Input> {
    R SelectDataByTime(int currentPage,int pageSize,String startTime,String endTime);
    R SelectAllData(int currentPage,int pageSize);
}
