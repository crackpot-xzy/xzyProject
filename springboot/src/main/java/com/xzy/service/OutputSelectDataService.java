package com.xzy.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xzy.controller.utils.R;
import com.xzy.domain.Input;
import com.xzy.domain.Output;

public interface OutputSelectDataService extends IService<Output> {
    R SelectDataByTime(int currentPage,int pageSize,String startTime,String endTime,Integer id);
    R SelectAllData(int currentPage,int pageSize,Integer id);
}
