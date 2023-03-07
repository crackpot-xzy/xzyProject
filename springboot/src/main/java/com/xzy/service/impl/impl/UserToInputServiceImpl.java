package com.xzy.service.impl.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xzy.controller.utils.R;
import com.xzy.dao.InputDao;
import com.xzy.domain.DTO.UserInputDto;
import com.xzy.domain.Input;
import com.xzy.service.impl.UserToInputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserToInputServiceImpl extends ServiceImpl<InputDao, Input> implements UserToInputService {

    @Autowired
    InputDao inputDao;

    @Override
    public R toInput(UserInputDto userInputDto) {
//        inputDao.UserToInput(userInputDto.getText(),userInputDto.getAttitudes(),userInputDto.getComments(),userInputDto.getReposts(),);
        return null;
    }
}
