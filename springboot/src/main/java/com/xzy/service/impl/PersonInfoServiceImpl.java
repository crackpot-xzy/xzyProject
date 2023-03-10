package com.xzy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xzy.controller.utils.R;
import com.xzy.dao.UserDao;
import com.xzy.domain.User;
import com.xzy.service.PersonInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class PersonInfoServiceImpl extends ServiceImpl<UserDao, User> implements PersonInfoService {

    @Autowired
    UserDao userDao;
    @Override
    public R ChangePersonInfo(User user) {
        if(user.getPassword().length()<6||user.getPassword().length()>18){
            return new R(false,null,"请输入6至18位密码");
        }else if(user.getName().length()>18){
            return new R(false,null,"用户名过长");
        }else if(user.getName().length()==0){
            return new R(false,null,"请输入用户名");
        }else if(user.getAddress()!=null&&user.getAddress()!=""&&user.getAddress().length()>50){
            return new R(false,null,"地址信息过长");
        }else if(user.getEmail()!=null&&user.getEmail()!=""&&IsMail(user.getEmail())==false){
            return new R(false,null,"请输入正确的邮箱格式");
        }else{
            Integer u = userDao.changeUserInfo(user.getId(),user.getName(),user.getPassword(),user.getAddress(),user.getEmail());
            if (u==null){
                return new R(false,null,"修改失败");
            }else{
                User res = userDao.selectById(user.getId());
                return new R(true,res,"修改成功");
            }
        }
    }

    @Override
    public Boolean IsMail(String str) {
        boolean flag = false;
        String regEx1 = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        Pattern p;
        Matcher m;
        p = Pattern.compile(regEx1);
        m = p.matcher(str);
        if(m.matches()){
            return true;
        }else {
            return false;
        }
    }
}
