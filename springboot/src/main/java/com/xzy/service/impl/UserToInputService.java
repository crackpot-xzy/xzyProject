package com.xzy.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xzy.controller.utils.R;
import com.xzy.domain.DTO.UserInputDto;
import com.xzy.domain.Input;

public interface UserToInputService extends IService<Input> {
    R toInput(UserInputDto userInputDto);
}
