package com.xzy.controller;

import com.xzy.controller.utils.R;
import com.xzy.service.impl.KeyWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Analysis")
public class AnalysisController {
    @Autowired
    KeyWordService keyWordService;

    public R KeyWords(){
        return null;
    }
}
