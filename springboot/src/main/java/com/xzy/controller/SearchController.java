package com.xzy.controller;

import com.xzy.controller.utils.R;
import com.xzy.service.impl.DeleteInputTabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Search")
public class SearchController {
    @Autowired
    DeleteInputTabService deleteInputTabService;
    @GetMapping("/delete")
    public R DeleteAll(){
        return deleteInputTabService.Delete();
    }
}
