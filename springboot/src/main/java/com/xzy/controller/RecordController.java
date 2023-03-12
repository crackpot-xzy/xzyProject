package com.xzy.controller;

import com.xzy.controller.utils.R;
import com.xzy.service.OutpuDeleteDataService;
import com.xzy.service.OutputSelectDataService;
import com.xzy.service.SaveToOutputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Record")
public class RecordController {

    @Autowired
    OutputSelectDataService outputSelectDataService;
    @Autowired
    OutpuDeleteDataService outpuDeleteDataService;

    @GetMapping("/selectData/{currentPage}/{pageSize}")
    public R selectData(@PathVariable int currentPage,@PathVariable int pageSize){
        return outputSelectDataService.SelectAllData(currentPage,pageSize);
    }
    @GetMapping("/selectData/{currentPage}/{pageSize}/{time}")
    public R selectData(@PathVariable int currentPage, @PathVariable int pageSize, @PathVariable String time){
        String[] timeSplit = time.split(",");
        return outputSelectDataService.SelectDataByTime(currentPage,pageSize,timeSplit[0],timeSplit[1]);
    }
    @GetMapping("/delete/{time}")
    public R deleteData(@PathVariable String time){
        String[] timeSplit = time.split(",");
        return outpuDeleteDataService.Delete(timeSplit[0],timeSplit[1]);
    }
    @GetMapping("/delete/")
    public R deleteData(){
            return new R(false,null,"请选择条件");
    }

}
