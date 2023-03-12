package com.xzy.service;

import java.io.File;

/**
 * @author xzy
 */
public class ClassifierConstant {
    public static String WEIBO_MODEL_PATH = null;
    public static String DATASET_WEIBO_PATH = null;
    static {
        WEIBO_MODEL_PATH = "B:/gitProject/xzyProject/zoom/model/nb-classifier-for-weibo.ser".replace("/", File.separator);
        DATASET_WEIBO_PATH = "B:/gitProject/xzyProject/zoom/data/weibo_senti_100k.csv".replace("/", File.separator);
    }
}



