package com.sjy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sjy.entity.Log;
import com.sjy.service.LogService;
import com.sjy.mapper.LogMapper;
import org.springframework.stereotype.Service;

/**
* @author sjy85
* @description 针对表【log】的数据库操作Service实现
* @createDate 2024-05-20 15:35:48
*/
@Service
public class LogServiceImpl extends ServiceImpl<LogMapper, Log>
    implements LogService{

}




