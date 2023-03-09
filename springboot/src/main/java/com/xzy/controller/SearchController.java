package com.xzy.controller;

import com.xzy.controller.utils.R;
import com.xzy.service.impl.DeleteInputTabService;
import com.xzy.service.impl.SelectDateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Search")
public class SearchController {
    @Autowired
    DeleteInputTabService deleteInputTabService;
    @Autowired
    SelectDateService selectDateService;

    @GetMapping("/delete")
    public R DeleteAll(){
        return deleteInputTabService.Delete();
    }
    //根据日期查询

    @GetMapping("/selectDate/{currentPage}/{pageSize}/{time}")
    public R selectDate(@PathVariable int currentPage,@PathVariable int pageSize,@PathVariable String time){
//        String s_out = StringUtils.strip(time,"[]");//用body接收的话返回的是一个数组形式[]，所以要去除[],但用路径就不会带括号
        String[] timeSplit = time.split(",");
        return selectDateService.SelectDateByTime(currentPage,pageSize,timeSplit[0],timeSplit[1]);
    }

    @GetMapping("/selectDate/{currentPage}/{pageSize}")
    public R selectDate(@PathVariable int currentPage,@PathVariable int pageSize){
        return selectDateService.SelectAllDate(currentPage,pageSize);
    }
}
