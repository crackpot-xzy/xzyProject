package com.xzy.service.impl.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xzy.controller.utils.R;
import com.xzy.dao.InputDao;
import com.xzy.domain.DTO.KeyWordDataDto;
import com.xzy.domain.Input;
import com.xzy.service.impl.KeyWordService;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class KeyWordServiceImpl extends ServiceImpl<InputDao, Input> implements KeyWordService {
    @Autowired
    InputDao inputDao;
    @Override
    public R getAllKeyWords() {
        //请求头中的token
        String token="98f0c8879f014018bf2ae7ebb895b4011678370438934token";
        //申请的接口地址
        String url="http://comdo.hanlp.com/hanlp/v1/keyword/extract";
        List<Input> ListInput = inputDao.selectList(null);
        List<String> res = new ArrayList<>();//所有关键字的结果数组
        for (int i = 0; i < ListInput.size(); i++) {
            //所有参数
            Map<String,Object> params=new HashMap<String,Object>();
            params.put("text",ListInput.get(i).getText());//取出文本信息
            params.put("size", "5");//最多提取5个关键词
            //执行api
            String s=doHanlpApi(token,url,params);//api返回结果
            //格式转换
            JSONObject obj= JSONObject.parseObject(s);//先转成对象
            JSONArray arrJson = obj.getJSONArray("data");//取出对象中对应的data元素
            List<KeyWordDataDto> arrJava = arrJson.toJavaList(KeyWordDataDto.class);
            for (int j = 0; j < arrJava.size(); j++) {
                res.add(arrJava.get(j).getWord());//依次取出关键词写入
            }
        }

        return null;
    }

    @Override
    public String doHanlpApi(String token, String url, Map<String, Object> params) {
        // 创建Httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        String resultString = "";
        try {
            // 创建Http Post请求
            HttpPost httpPost = new HttpPost(url);
            //添加header请求头，token请放在header里
            httpPost.setHeader("token", token);
            // 创建参数列表
            List<NameValuePair> paramList = new ArrayList<>();
            if (params != null) {
                for (String key : params.keySet()) {
                    //所有参数依次放在paramList中
                    paramList.add(new BasicNameValuePair(key, (String) params.get(key)));
                }
                //模拟表单
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paramList, "utf-8");
                httpPost.setEntity(entity);
            }
            // 执行http请求
            response = httpClient.execute(httpPost);
            resultString = EntityUtils.toString(response.getEntity(), "utf-8");
            return resultString;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(response!=null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
