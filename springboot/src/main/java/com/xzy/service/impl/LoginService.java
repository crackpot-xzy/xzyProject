package com.xzy.service.impl;


import com.baomidou.mybatisplus.extension.service.IService;
import com.xzy.controller.utils.R;
import com.xzy.domain.User;

public interface LoginService extends IService<User> {
    //登录
    R Login(User user);
}
