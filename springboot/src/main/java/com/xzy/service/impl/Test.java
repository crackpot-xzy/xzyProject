package com.xzy.service.impl;


import com.xzy.service.ClassifierConstant;
import com.xzy.service.HanLpClassifier;

/**
 * @author 32098
 *
 * 情感分类、中文文本分类
 */
public class Test {
    public static void main(String[] args) {
        HanLpClassifier.initClassifier(ClassifierConstant.DATASET_WEIBO_PATH, ClassifierConstant.WEIBO_MODEL_PATH);
        System.out.println(HanLpClassifier.getClassification("天安门"));
        System.out.println(HanLpClassifier.getClassification("哇哦今年的春夏季衣服不错诶"));
        System.out.println(HanLpClassifier.getClassification("去死吧"));
        System.out.println(HanLpClassifier.getClassification("加油"));
        System.out.println(HanLpClassifier.getClassification("你真好"));
        System.out.println(HanLpClassifier.getScoreOfWeiboComment("你真好"));

    }
}
