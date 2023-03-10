package com.xzy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xzy.controller.utils.CsvImportUtil;
import com.xzy.controller.utils.R;
import com.xzy.dao.InputDao;
import com.xzy.domain.Input;
import com.xzy.service.CsvToInputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class CsvToInputServiceImpl extends ServiceImpl<InputDao, Input> implements CsvToInputService {

    @Autowired
    InputDao inputDao;

    @Override
    public R toInput(MultipartFile file) {
        // 使用CSV工具类，生成file文件
        File csvFile = CsvImportUtil.uploadFile(file);
        // 将文件内容解析，存入List容器，List<String>为每一行内容的集合，colNum为CSV文件每行的总列数
        List<List<String>> lists = CsvImportUtil.readCSV(csvFile.getPath(), 7);
        if (lists.size()<1){
            return new R(false,null,"上传失败");
        }
        int count=0;//统计添加的记录条数
        for(int i=0;i<lists.size();i++){
            //判断文件内容的格式
            String pattern ="yyyy-MM-dd HH:mm:ss";
            SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
            if(dateStrIsValid(lists.get(i).get(6),pattern)==false){
                return new R(false,null,"请导入正确的日期格式");
            }else if (isNumeric(lists.get(i).get(0))==false||isNumeric(lists.get(i).get(3))==false||isNumeric(lists.get(i).get(4))==false||isNumeric(lists.get(i).get(5))==false){
                return new R(false,null,"请导入正确的数值");
            }else if (lists.get(i).get(1).equals("")){
                return new R(false,null,"导入文本信息存在空值");
            }
            if(inputDao.selectById(lists.get(i).get(0))!=null){//表中已有该条记录
                continue;
            }else {
                count++;
                inputDao.FileToInput(lists.get(i).get(0), lists.get(i).get(1), Integer.valueOf(lists.get(i).get(5)), Integer.valueOf(lists.get(i).get(4)), Integer.valueOf(lists.get(i).get(3)), lists.get(i).get(6), lists.get(i).get(2));
            }
        }
        //删除文件
        csvFile.delete();
        return new R(true,null,"成功导入"+count+"条数据");
    }

    @Override
    public Boolean dateStrIsValid(String rawDateStr, String pattern){
        Boolean res = true;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
            Date date = dateFormat.parse(rawDateStr);
            res = rawDateStr.equals(dateFormat.format(date));
        }catch (ParseException e){
            res=false;
        }finally {
            return res;
        }
    }

    @Override
    public Boolean isNumeric(String str) {
        if(str.equals("")) return false;//""需要特判
        Pattern pattern = Pattern.compile("[0-9]*");
        return pattern.matcher(str).matches();
    }
}
