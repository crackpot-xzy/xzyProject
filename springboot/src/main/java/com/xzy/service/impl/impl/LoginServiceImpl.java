package com.xzy.service.impl.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xzy.dao.UserDao;
import com.xzy.domain.User;
import com.xzy.service.impl.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoginServiceImpl extends ServiceImpl<UserDao, User> implements LoginService {

    @Autowired
    private UserDao userDao;

    @Override
    public Boolean Login(User user) {
        Integer result=userDao.selectByAccount(user.getAccount(),user.getPassword());
        if(result==null){
            return false;
        }else{
            return true;
        }
    }
}
