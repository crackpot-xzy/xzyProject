package com.xzy.controller;

import com.xzy.controller.utils.R;
import com.xzy.service.DeleteInputTabService;
import com.xzy.service.SelectDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Search")
public class SearchController {
    @Autowired
    DeleteInputTabService deleteInputTabService;
    @Autowired
    SelectDataService selectDataService;

    @GetMapping("/delete/")
    public R DeleteAll(){
        return deleteInputTabService.Delete();
    }

    @GetMapping("/delete/{time}")
    public R DeleteByTime(@PathVariable String time){
        String[] timeSplit = time.split(",");
        return deleteInputTabService.Delete(timeSplit[0],timeSplit[1]);
    }
    //根据日期查询

    @GetMapping("/selectData/{currentPage}/{pageSize}/{time}")
    public R selectData(@PathVariable int currentPage,@PathVariable int pageSize,@PathVariable String time){
//        String s_out = StringUtils.strip(time,"[]");//用body接收的话返回的是一个数组形式[]，所以要去除[],但用路径就不会带括号
        String[] timeSplit = time.split(",");
        return selectDataService.SelectDataByTime(currentPage,pageSize,timeSplit[0],timeSplit[1]);
    }
    @GetMapping("/selectData/{currentPage}/{pageSize}")
    public R selectData(@PathVariable int currentPage,@PathVariable int pageSize){
        return selectDataService.SelectAllData(currentPage,pageSize);
    }
}
