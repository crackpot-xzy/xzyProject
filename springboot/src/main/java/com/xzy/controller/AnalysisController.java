package com.xzy.controller;

import com.xzy.controller.utils.R;
import com.xzy.service.EmoService;
import com.xzy.service.HotService;
import com.xzy.service.KeyWordService;
import com.xzy.service.SaveToOutputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Analysis")
public class AnalysisController {
    @Autowired
    KeyWordService keyWordService;
    @Autowired
    HotService hotService;
    @Autowired
    EmoService emoService;
    @Autowired
    SaveToOutputService saveToOutputService;

    @GetMapping("/all")
    public R KeyWordsAll(){
        return keyWordService.getAllKeyWords();
    }

    @GetMapping("/byTime/{time}")
    public R KeyWordsByTime(@PathVariable String time){
        try{
            String[] timeSplit = time.split(",");
            return  keyWordService.getKeyWordsByTime(timeSplit[0],timeSplit[1]);
        }catch (Exception e){
            return new R(false,null,"请选择正确的时间");
        }
    }

    @GetMapping("/all/hot")
    public R hotAll(){
        return hotService.getAllHot();
    }

    @GetMapping("/byTime/hot/{time}")
    public R hotByTime(@PathVariable String time){
        try{
            String[] timeSplit = time.split(",");
            return hotService.getHotByTime(timeSplit[0],timeSplit[1]);
        }catch (Exception e){
            return new R(false,null,"请选择正确的时间");
        }
    }

    @GetMapping("/all/emo/{id}")
    public R EmoAll(@PathVariable Integer id){
        return emoService.getAllEmo(id);
    }

    @GetMapping("/byTime/emo/{time}/{id}")
    public R EmoByTime(@PathVariable String time,@PathVariable Integer id){
        try{
            String[] timeSplit = time.split(",");
            return emoService.getEmoByTime(timeSplit[0],timeSplit[1],id);
        }catch (Exception e){
            return new R(false,null,"请选择正确的时间");
        }
    }

    @GetMapping("/save")
    public R SaveToOutput(){
        return saveToOutputService.saveToOutput();
    }
}
