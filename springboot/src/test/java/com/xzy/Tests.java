package com.xzy;

import cn.hutool.core.convert.ConvertException;
import cn.hutool.http.HttpException;
import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.alibaba.druid.support.json.JSONUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
//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
//    https://23326.xyz/

class Tests {
    @Test
    public static String chat(String txt) {
        String text="你是什么东西";
        String chatEndpoint = "https://api.openai.com/v1/chat/completions";
        String apiKey = "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";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("model", "gpt-3.5-turbo");
        List<Map<String, String>> dataList = new ArrayList<>();
        dataList.add(new HashMap<String, String>(){{
            put("role", "user");
            put("content", text);
        }});
        paramMap.put("messages", dataList);
        JSONObject message = null;
        try {
            String body = HttpRequest.post(chatEndpoint)
                    .header("Authorization", apiKey)
                    .header("Content-Type", "application/json")
                    .body(JSONUtils.toJSONString(paramMap))
                    .execute()
                    .body();
            JSONObject jsonObject = JSONUtil.parseObj(body);
            JSONArray choices = jsonObject.getJSONArray("choices");
            JSONObject result = choices.get(0, JSONObject.class, Boolean.TRUE);
            message = result.getJSONObject("message");
        } catch (HttpException e) {
            System.out.println("1");
            return "出现了异常";
        } catch (ConvertException e) {
            System.out.println("2");
            return "出现了异常";
        }
        System.out.println(message.getStr("content"));
        return message.getStr("content");
    }
    @Test
    public static void main(String[] args) {
        System.out.println(chat("Hello，一个小浪吴啊"));
    }
}
