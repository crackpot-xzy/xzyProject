package com.xzy;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xzy.domain.DTO.KeyWordDataDto;
import com.xzy.domain.DTO.NameValueDto;
import com.xzy.service.impl.KeyWordService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
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

    @Autowired
    KeyWordService keyWordService;
    @Test
    public void keyWords(){
        String token="98f0c8879f014018bf2ae7ebb895b4011678370438934token";
        //申请的接口地址
        String url="http://comdo.hanlp.com/hanlp/v1/keyword/extract";
        //所有参数
        Map<String,Object> params=new HashMap<String,Object>();
        params.put("text", "看似海王，实则寡王\uD83D\uDE05\uD83D\uDE05我在杭州杭州杭州杭州杭州杭州的渣女人设深深立住了，就无语我只是在认真享受并分享我的生活，趁年轻尽情打扮自己而已啊");
        params.put("size", "5");
        String s = keyWordService.doHanlpApi(token,url,params);
        System.out.println(s);
//        List<KeyWordDto> listStr = JSON.parseArray(s,KeyWordDto.class);
        JSONObject obj= JSONObject.parseObject(s);
        JSONArray arr = obj.getJSONArray("data");
        List<KeyWordDataDto> arr2 = arr.toJavaList(KeyWordDataDto.class);
//        List<KeyWordData> listStr = JSON.parseArray(arr,KeyWordData.class);
        System.out.println(arr2);
        Map<String,Integer> res = new HashMap<>();
        for (int i = 0; i < arr2.size(); i++) {
            if(res.get(arr2.get(i).getWord())==null){
                res.put(arr2.get(i).getWord(),1);
            }else{
                Integer value = res.get(arr2.get(i).getWord())+1;
                res.put(arr2.get(i).getWord(),value);
            }
        }
        //取出map中的键值对
        System.out.println(res);
        for(String key : res.keySet()){
            Integer value = res.get(key);
            System.out.println(key+"  "+value);
        }
//        List<NameValueDto> listNameValue = new ArrayList<>();
//        for (int i = 0; i < res.size(); i++) {
//            NameValueDto nameValueDto;
//            nameValueDto.setName();
//            listNameValue.add()
//        }
//        String json= JSON.toJSONString(res);
//        System.out.println(json);
    }

}
