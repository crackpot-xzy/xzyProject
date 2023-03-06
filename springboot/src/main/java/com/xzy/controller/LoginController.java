package com.xzy.controller;

import com.xzy.controller.utils.R;
import com.xzy.domain.User;
import com.xzy.service.impl.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Login")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping
    public R get(@RequestBody User user){
        return new R(loginService.Login(user));
//        return new R(false);
    }
}
