package com.xzy.service.impl.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xzy.controller.utils.R;
import com.xzy.dao.InputDao;
import com.xzy.domain.DTO.UserInputDto;
import com.xzy.domain.Input;
import com.xzy.service.impl.UserToInputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

@Service
public class UserToInputServiceImpl extends ServiceImpl<InputDao, Input> implements UserToInputService {

    @Autowired
    InputDao inputDao;

    @Override
    public R toInput(UserInputDto userInputDto) {

        if(dateStrIsValid(userInputDto.getTime(),"yyyy-MM-dd HH:mm:ss")==false){
            return new R(false,null,"请输入正确的日期格式");
        }else if(isNumeric(userInputDto.getAttitudes())==false||isNumeric(userInputDto.getComments())==false||isNumeric(userInputDto.getReposts())==false){
            return new R(false,null,"请输入正确的数值");
        }else if(userInputDto.getText().equals("")){
            return new R(false,null,"文本信息不能为空");
        }else{
            int res= inputDao.UserToInput(userInputDto.getText(),userInputDto.getAttitudes(),userInputDto.getComments(),userInputDto.getReposts(),userInputDto.getTime());
            return new R(true,null,"成功添加"+res+"条数据");
        }
    }

    @Override
    public Boolean dateStrIsValid(String rawDateStr, String pattern){
        Boolean res = true;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
            Date date = dateFormat.parse(rawDateStr);
            res = rawDateStr.equals(dateFormat.format(date));
        }catch (ParseException e){
            res=false;
        }finally {
            return res;
        }
    }

    @Override
    public Boolean isNumeric(String str) {
        if(str.equals("")) return false;//""需要特判
        Pattern pattern = Pattern.compile("[0-9]*");
        return pattern.matcher(str).matches();
    }
}
