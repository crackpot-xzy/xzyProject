package com.xzy.controller.utils;

import lombok.Data;

@Data
public class R {
    private Boolean flag;//操作成功、失败
    private Object data;
    private String msg;

    public R(){

    }

    public R(Boolean flag,Object data,String msg){
        this.flag = flag;
        this.data = data;
        this.msg = msg;
    }

}
