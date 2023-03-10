package com.xzy.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xzy.controller.utils.R;
import com.xzy.domain.DTO.UserInputDto;
import com.xzy.domain.Input;
import org.springframework.web.multipart.MultipartFile;

public interface CsvToInputService extends IService<Input> {
    R toInput(MultipartFile file);
    Boolean dateStrIsValid(String rawDateStr, String pattern);
    Boolean isNumeric(String str);
}
