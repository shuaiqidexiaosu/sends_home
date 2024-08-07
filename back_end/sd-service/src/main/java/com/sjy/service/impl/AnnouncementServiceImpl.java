package com.sjy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sjy.entity.Announcement;
import com.sjy.mapper.AnnouncementMapper;
import com.sjy.service.AnnouncementService;
import org.springframework.stereotype.Service;

/**
* @author sjy85
* @description 针对表【announcement】的数据库操作Service实现
* @createDate 2024-05-20 15:35:48
*/
@Service
public class AnnouncementServiceImpl extends ServiceImpl<AnnouncementMapper, Announcement>
    implements AnnouncementService{

}




