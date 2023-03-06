package com.xzy.controller;

import com.xzy.controller.utils.R;
import com.xzy.domain.DTO.SignDto;
import com.xzy.domain.User;
import com.xzy.service.impl.LoginService;
import com.xzy.service.impl.SignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class LoginController {
    @Autowired
    private LoginService loginService;
    @Autowired
    private SignService signService;

    @PostMapping("/Login")
    public R Login(@RequestBody User user){
        return loginService.Login(user);
    }
    @PostMapping("/Sign")
    public R Sign(@RequestBody SignDto signDto){
        return signService.Sign(signDto);
    }
}
