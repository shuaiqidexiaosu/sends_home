package com.sjy.mapper;

import com.sjy.entity.Announcement;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author sjy85
* @description 针对表【announcement】的数据库操作Mapper
* @createDate 2024-05-20 15:35:48
* @Entity com.sjy.entity.Announcement
*/
@Mapper
public interface AnnouncementMapper extends BaseMapper<Announcement> {
}




