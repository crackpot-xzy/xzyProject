package com.xzy.controller;

import com.xzy.controller.utils.R;
import com.xzy.service.impl.KeyWordService;
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

    @GetMapping("/all")
    public R KeyWordsAll(){
        return keyWordService.getAllKeyWords();
    }

    @GetMapping("/byTime/{time}")
    public R KeyWordsByTime(@PathVariable String time){
        String[] timeSplit = time.split(",");
        return  keyWordService.getAllKeyWords(timeSplit[0],timeSplit[1]);
    }
}
