package com.xzy.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xzy.controller.utils.R;
import com.xzy.domain.DTO.SignDto;
import com.xzy.domain.User;

public interface SignService extends IService<User> {
    R Sign(SignDto signDto);
    Boolean IsPhone(String phone);
}
