package com.xzy.controller;

import com.xzy.controller.utils.R;
import com.xzy.domain.DTO.TimeDto;
import com.xzy.service.impl.DeleteInputTabService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Search")
public class SearchController {
    @Autowired
    DeleteInputTabService deleteInputTabService;

    @GetMapping("/delete")
    public R DeleteAll(){
        return deleteInputTabService.Delete();
    }
    @PostMapping("/selectDate")
    public R selectDate(@RequestBody String s){
        System.out.println(s);
        String s_out = StringUtils.strip(s,"[]");
        String[] start = s_out.split(",");
        return new R(true,null,start[0]);
    }
}
