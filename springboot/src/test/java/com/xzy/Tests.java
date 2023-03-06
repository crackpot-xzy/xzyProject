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
    @Autowired
    private TableDao tableDao;

    @Test
    void testGetById(){
        System.out.println("这是结果------》"+userDao.selectById(1));
    }
    @Test
    void testGetById2(){
        System.out.println("这是结果------》"+tableDao.selectById(1));
    }

}
