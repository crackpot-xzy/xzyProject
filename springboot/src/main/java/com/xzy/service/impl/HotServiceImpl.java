package com.xzy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xzy.controller.utils.R;
import com.xzy.dao.InputDao;
import com.xzy.domain.Input;
import com.xzy.service.EmoService;
import com.xzy.service.HotService;
import org.springframework.stereotype.Service;

@Service
public class HotServiceImpl extends ServiceImpl<InputDao, Input> implements HotService {

    @Override
    public R getAllHot() {
        return null;
    }

    @Override
    public R getHotByTime(String startTime, String endTime) {
        return null;
    }
}
