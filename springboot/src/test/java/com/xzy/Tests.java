package com.xzy;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hankcs.hanlp.HanLP;
import com.xzy.dao.InputDao;
import com.xzy.domain.DTO.KeyWordDataDto;
import com.xzy.domain.DTO.NameValueDto;
import com.xzy.domain.Input;
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
//        取出map中的键值对
        System.out.println(res);
        for(String key : res.keySet()){
            Integer value = res.get(key);
            System.out.println(key+"  "+value);
        }
//        List<NameValueDto> listNameValue = new ArrayList<>();
//        for(String key : res.keySet()){
//            Integer value = res.get(key);
//            NameValueDto nameValueDto = new NameValueDto();
//            nameValueDto.setName(key);
//            nameValueDto.setValue(value);
//            listNameValue.add(nameValueDto);
//        }
        String json= JSON.toJSONString(res);
        System.out.println(json);
    }

    //http://www.hankcs.com/nlp/hanlp.html 参考文章
    @Autowired
    InputDao inputDao;
    @Test
    public void testhanlp(){
        //数据层操作
        List<Input> ListInput = inputDao.selectList(null);

        Map<String,Integer> res = new HashMap<>();//所有关键字的结果数组,进行词频统计
        for (int i = 0; i < ListInput.size(); i++) {
            String s = ListInput.get(i).getText();
            //提取关键词
            List<String> keywordList = HanLP.extractKeyword(s, 50);
            //词频统计
            for (int j = 0; j < keywordList.size(); j++) {
                if(res.get(keywordList.get(j))==null){//map中没有该关键词
                    res.put(keywordList.get(j),1);
                }else{
                    Integer value = res.get(keywordList.get(j))+1;
                    res.put(keywordList.get(j),value);
                }
            }
        }
        //取出map中的键值对
        List<NameValueDto> listNameValue = new ArrayList<>();
        for(String key : res.keySet()){
            NameValueDto nameValueDto = new NameValueDto();
            Integer value = res.get(key);
            if (value>10&&!(key.equals("#")||key.equals("@")||key.equals("L"))){
                nameValueDto.setName(key);
                nameValueDto.setValue(value);
                listNameValue.add(nameValueDto);
            }
        }
        System.out.println(listNameValue);
    }

}
