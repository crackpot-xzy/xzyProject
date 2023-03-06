package com.xzy;

import com.xzy.dao.TableDao;
import com.xzy.dao.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Tests {

    @Autowired
    private UserDao userDao;

    @Test
    void testGetById(){
//        System.out.println("这是结果------》"+userDao.selectByAccount(100001,"root"));
    }


}
