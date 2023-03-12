package com.xzy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xzy.controller.utils.R;
import com.xzy.dao.InputDao;
import com.xzy.domain.Input;
import com.xzy.service.ClassifierConstant;
import com.xzy.service.EmoService;
import com.xzy.service.HanLpClassifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class EmoServiceImpl extends ServiceImpl<InputDao, Input> implements EmoService {

    @Autowired
    InputDao inputDao;
    @Override
    public R getAllEmo(Integer id) {
        List<Input> ListInput = inputDao.selectList(null);
        HanLpClassifier.initClassifier(ClassifierConstant.DATASET_WEIBO_PATH, ClassifierConstant.WEIBO_MODEL_PATH);
        //用于存储good neu bad 数量
        List list = new ArrayList<>();
        int good=0;int neu=0;int bad=0;
        for (int i = 0; i < ListInput.size(); i++) {
            double score = HanLpClassifier.getScoreOfWeiboComment(ListInput.get(i).getText());
            int type;
            if(score>-0.00002&&score<0.00002){
                type=0;
                neu++;
            }else if (score>=0.00002){
                type=1;
                good++;
            }else{
                type=-1;
                bad++;
            }
            //写入emo 所属用户 编辑时间
            Input input = ListInput.get(i);
            input.setEmo(type);
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String editTime = formatter.format(date);
            input.setEdit(editTime);
            input.setUser(id);
            inputDao.updateById(input);
        }
        list.add(good);list.add(neu);list.add(bad);
        return new R(true,list,"全部数据情感分析成功");
    }

    @Override
    public R getEmoByTime(String startTime, String endTime,Integer id) {
        QueryWrapper<Input> wrapper = new QueryWrapper<>();
        wrapper.between("created",startTime,endTime);
        List<Input> ListInput = inputDao.selectList(wrapper);
        HanLpClassifier.initClassifier(ClassifierConstant.DATASET_WEIBO_PATH, ClassifierConstant.WEIBO_MODEL_PATH);
        //用于存储good neu bad 数量
        List list = new ArrayList<>();
        int good=0;int neu=0;int bad=0;
        for (int i = 0; i < ListInput.size(); i++) {
            double score = HanLpClassifier.getScoreOfWeiboComment(ListInput.get(i).getText());
            int type;
            if(score>-0.00002&&score<0.00002){
                type=0;
                neu++;
            }else if (score>=0.00002){
                type=1;
                good++;
            }else{
                type=-1;
                bad++;
            }
            //写入emo 所属用户 编辑时间
            Input input = ListInput.get(i);
            input.setEmo(type);
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String editTime = formatter.format(date);
            input.setEdit(editTime);
            input.setUser(id);
            inputDao.updateById(input);
        }
        list.add(good);list.add(neu);list.add(bad);
        return new R(true,list,"该时间段数据情感分析成功");
    }
}
