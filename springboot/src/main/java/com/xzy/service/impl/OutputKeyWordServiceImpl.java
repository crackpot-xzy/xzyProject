package com.xzy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hankcs.hanlp.HanLP;
import com.xzy.controller.utils.R;
import com.xzy.dao.OutputDao;
import com.xzy.domain.DTO.NameValueDto;
import com.xzy.domain.Output;
import com.xzy.service.OutputKeyWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OutputKeyWordServiceImpl extends ServiceImpl<OutputDao, Output> implements OutputKeyWordService {
    @Autowired
    OutputDao outputDao;


    @Override
    public R getAllKeyWords() {
        //数据层操作
        List<Output> ListOutput = outputDao.selectList(null);

        //http://www.hankcs.com/nlp/hanlp.html 参考文章
        Map<String,Integer> res = new HashMap<>();//所有关键字的结果数组,进行词频统计
        for (int i = 0; i < ListOutput.size(); i++) {
            String s = ListOutput.get(i).getText();
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
            if (value>10&&!(key.equals("#")||key.equals("@")||key.equals("L")||key.equals("##")
                    ||key.equals("#L")))
            {//进行筛选
                nameValueDto.setName(key);
                nameValueDto.setValue(value);
                listNameValue.add(nameValueDto);
            }
        }
        Collections.sort(listNameValue);//返回排序后的数据
        return new R(true,listNameValue,"全部关键词分析完成");
    }

    @Override
    public R getKeyWordsByTime(String startTime,String endTime) {
        //数据层操作
        QueryWrapper<Output> wrapper = new QueryWrapper<>();
        wrapper.between("created",startTime,endTime);
        List<Output> ListOutput = outputDao.selectList(wrapper);

        //http://www.hankcs.com/nlp/hanlp.html 参考文章
        Map<String,Integer> res = new HashMap<>();//所有关键字的结果数组,进行词频统计
        for (int i = 0; i < ListOutput.size(); i++) {
            String s = ListOutput.get(i).getText();
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
            if (value>10&&!(key.equals("#")||key.equals("@")||key.equals("L")||key.equals("##")
                    ||key.equals("#L")))
            {//进行筛选
                nameValueDto.setName(key);
                nameValueDto.setValue(value);
                listNameValue.add(nameValueDto);
            }
        }
        Collections.sort(listNameValue);//返回排序后的数据
        return new R(true,listNameValue,"该时间段关键词分析完成");
    }
}
