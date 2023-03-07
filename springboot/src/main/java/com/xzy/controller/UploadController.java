package com.xzy.controller;

import com.xzy.controller.utils.R;
import com.xzy.service.impl.SpiderToInputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Upload")
public class UploadController {

    @Autowired
    private SpiderToInputService spiderToInputService;

    @GetMapping("/SpiderTo")
    public R SpiderToInput(){
        return spiderToInputService.toInput();
    }

}
