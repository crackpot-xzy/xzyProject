package com.xzy.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xzy.controller.utils.R;
import com.xzy.domain.User;

public interface PersonInfoService extends IService<User> {
    R ChangePersonInfo(User user);
    Boolean IsMail(String str);
}
