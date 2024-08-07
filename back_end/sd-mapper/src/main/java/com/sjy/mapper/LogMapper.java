package com.sjy.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sjy.entity.Log;
import org.apache.ibatis.annotations.Mapper;

/**
* @author sjy85
* @description 针对表【log】的数据库操作Mapper
* @createDate 2024-05-20 15:35:48
* @Entity com.sjy.entity.Log
*/
@Mapper
public interface LogMapper extends BaseMapper<Log> {

}




