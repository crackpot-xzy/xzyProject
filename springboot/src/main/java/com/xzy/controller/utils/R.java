package com.xzy.controller.utils;

import lombok.Data;

@Data
public class R {
    private Boolean flag;//操作成功、失败
    private Object data;
    private String msg;

    public R(){
    }

    //成功
    public R(Object data){
        this.flag = true;
        this.data = data;
    }

    //异常
    public R(String msg){
        this.flag = false;
        this.msg = msg;
    }
}
