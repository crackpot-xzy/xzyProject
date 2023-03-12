package com.xzy.controller;

import com.xzy.controller.utils.R;
import com.xzy.service.OutpuDeleteDataService;
import com.xzy.service.OutputKeyWordService;
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
    @Autowired
    OutputKeyWordService outputKeyWordService;

    @GetMapping("/selectData/{currentPage}/{pageSize}/{id}")
    public R selectData(@PathVariable int currentPage,@PathVariable int pageSize,@PathVariable Integer id){
        return outputSelectDataService.SelectAllData(currentPage,pageSize,id);
    }
    @GetMapping("/selectData/{currentPage}/{pageSize}/{time}/{id}")
    public R selectData(@PathVariable int currentPage, @PathVariable int pageSize, @PathVariable String time,@PathVariable Integer id){
        try{
            String[] timeSplit = time.split(",");
            return outputSelectDataService.SelectDataByTime(currentPage,pageSize,timeSplit[0],timeSplit[1],id);
        }catch (Exception e){
            return new R(false,null,"请选择正确的时间");
        }
    }

    @GetMapping("/delete/{time}/{id}")
    public R deleteData(@PathVariable String time,@PathVariable Integer id){
        try{
            String[] timeSplit = time.split(",");
            return outpuDeleteDataService.Delete(timeSplit[0],timeSplit[1],id);
        }catch (Exception e){
            return new R(false,null,"请选择正确的时间");
        }
    }
    @GetMapping("/all/{id}")
    public R KeyWordsAll(@PathVariable Integer id){
        return outputKeyWordService.getAllKeyWords(id);
    }

    @GetMapping("/byTime/{time}/{id}")
    public R KeyWordsByTime(@PathVariable String time,@PathVariable Integer id){
        try{
            String[] timeSplit = time.split(",");
            return  outputKeyWordService.getKeyWordsByTime(timeSplit[0],timeSplit[1],id);
        }catch (Exception e){
            return new R(false,null,"请选择正确的时间");
        }
    }

}
