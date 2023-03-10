package com.xzy.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xzy.controller.utils.R;
import com.xzy.domain.DTO.UserInputDto;
import com.xzy.domain.Input;

import java.text.ParseException;

public interface UserToInputService extends IService<Input> {
    R toInput(UserInputDto userInputDto);
    Boolean dateStrIsValid(String rawDateStr, String pattern);
    Boolean isNumeric(String str);

}
