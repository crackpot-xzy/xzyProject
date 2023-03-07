package com.xzy;

import com.xzy.dao.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

@SpringBootTest
class Tests {

    @Test
    void testtime(){
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("结果=====》"+formatter.format(date));
    }

    @Test
    static void dateStrIsValid(String rawDateStr, String pattern) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        Date date = null;
        try {
            // 转化为 Date类型测试判断
            date = dateFormat.parse(rawDateStr);
            System.out.println(rawDateStr.equals(dateFormat.format(date)));
        } catch (ParseException e) {
            System.out.println(false);
        }finally {

        }
    }
    @Test
    public static Boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        return pattern.matcher(str).matches();
    }
    @Test
    public static void main(String[] args) throws ParseException {
//        Tests.dateStrIsValid("2021-03-01 20:20","yyyy-MM-dd HH:mm:ss");
        System.out.println(Tests.isNumeric(""));
    }


}
