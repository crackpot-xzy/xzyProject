package com.xzy.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hankcs.hanlp.HanLP;
import com.xzy.controller.utils.R;
import com.xzy.dao.InputDao;
import com.xzy.domain.DTO.KeyWordDataDto;
import com.xzy.domain.DTO.NameValueDto;
import com.xzy.domain.Input;
import com.xzy.service.EmoService;
import com.xzy.service.KeyWordService;
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
import java.util.*;

@Service
public class EmoServiceImpl extends ServiceImpl<InputDao, Input> implements EmoService {

    @Override
    public R getAllEmo() {
        return null;
    }

    @Override
    public R getEmoByTime(String startTime, String endTime) {
        return null;
    }
}
