package com.xzy.controller;

import com.xzy.controller.utils.R;
import com.xzy.domain.DTO.UserInputDto;
import com.xzy.service.impl.CsvToInputService;
import com.xzy.service.impl.SpiderToInputService;
import com.xzy.service.impl.UserToInputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/Upload")
public class UploadController {

    @Autowired
    private SpiderToInputService spiderToInputService;
    @Autowired
    private UserToInputService userToInputService;
    @Autowired
    private CsvToInputService csvToInputService;

    @GetMapping("/SpiderTo")
    public R SpiderToInput(){
        return spiderToInputService.toInput();
    }
    @PostMapping("/UserTo")
    public R UserToInput(@RequestBody UserInputDto userInputDto){
        return userToInputService.toInput(userInputDto);
    }
    @PostMapping("/CsvTo")
    public R CsvToInput(@RequestParam MultipartFile file){
        return csvToInputService.toInput(file);
    }
}
