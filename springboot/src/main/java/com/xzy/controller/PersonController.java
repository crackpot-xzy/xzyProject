package com.xzy.controller;

import com.xzy.controller.utils.R;
import com.xzy.domain.User;
import com.xzy.service.PersonInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Person")
public class PersonController {
    @Autowired
    private PersonInfoService personInfoService;
    @PostMapping
    public R ChangeInfo(@RequestBody User user){
        return personInfoService.ChangePersonInfo(user);
    }
}
