package com.xzy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xzy.controller.utils.R;
import com.xzy.dao.UserDao;
import com.xzy.domain.DTO.SignDto;
import com.xzy.domain.User;
import com.xzy.service.SignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class SignServiceImpl  extends ServiceImpl<UserDao, User> implements SignService {

    @Autowired
    UserDao userDao;

    @Override
    public R Sign(SignDto signDto) {
        if(IsPhone(signDto.getAccount())==false){
            return new R(false,null,"请输入正确的电话格式");
        }else if(signDto.getPassword().length()<6||signDto.getPassword().length()>18){
            return new R(false,null,"请输入6至18位密码");
        }else if(signDto.getPassword().equals(signDto.getPasswordTo())==false){
            return new R(false,null,"两次输入密码不一致");
        }else if(userDao.selectByAccount(signDto.getAccount())!=null){
            return new R(false,null,"账户已注册");
        }else{
            Integer r = userDao.insertAccountPassword(signDto.getAccount(),signDto.getPassword());
            if(r==null){
                return new R(false,null,"注册失败");
            }else{
                return new R(true,null,"注册成功，请登录账户");
            }

        }
    }

    @Override
    public Boolean IsPhone(String phone) {
        String regex = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$";
        if (phone.length() != 11) {
            return false;
        } else {
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(phone);
            return m.matches();
        }
    }
}
