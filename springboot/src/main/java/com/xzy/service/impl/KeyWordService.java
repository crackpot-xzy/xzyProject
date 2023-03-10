package com.xzy.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xzy.controller.utils.R;
import com.xzy.domain.Input;

import java.util.Map;

public interface KeyWordService extends IService<Input> {
    R getAllKeyWords();
    String doHanlpApi(String token, String url, Map<String,Object> params);

}
