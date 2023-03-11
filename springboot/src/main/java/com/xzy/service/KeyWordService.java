package com.xzy.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xzy.controller.utils.R;
import com.xzy.domain.Input;

import java.util.Map;

public interface KeyWordService extends IService<Input> {
    R getAllKeyWordsAPI();
    R getAllKeyWords();
    R getKeyWordsByTime(String startTime,String endTime);
    String doHanlpApi(String token, String url, Map<String,Object> params);

}
