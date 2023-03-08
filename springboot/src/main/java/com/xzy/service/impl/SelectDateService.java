package com.xzy.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xzy.controller.utils.R;
import com.xzy.domain.DTO.TimeDto;
import com.xzy.domain.Input;

public interface SelectDateService extends IService<Input> {
    R selectDate(TimeDto timeDto);
}
