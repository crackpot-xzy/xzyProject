package com.xzy.service.impl.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xzy.controller.utils.R;
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
    public R Login(User user) {
        if(userDao.selectByAccount(user.getAccount())==null){
            return new R(false,null,"账号不存在");
        }else{
            User u = userDao.selectByAccountPassword(user.getAccount(),user.getPassword());
            if (u==null){
                return new R(false,null,"密码错误");
            }else{
                if(u.getPrivileges()==0){
                    return new R(false,null,"当前账号无权访问");
                }
                return new R(true,u,null);
            }
        }
    }
}
