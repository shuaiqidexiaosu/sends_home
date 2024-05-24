package com.sjy.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sjy.entity.Announcement;
import com.sjy.entity.User;
import com.sjy.res.ResData;
import com.sjy.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController()
@RequestMapping("/announcement")
public class AnnouncementController {


    @Autowired
    private AnnouncementService announcementService;

    //    根据年份获取公告信息
    @GetMapping("/getAnnouncementByYear/{year}")
    public ResData<List<Announcement>> getAnnouncementByYear(@PathVariable Integer year) {
        QueryWrapper<Announcement> wrapper = new QueryWrapper<>();
        wrapper.eq("year", year);
        List<Announcement> list = announcementService.list(wrapper);
        if (list.isEmpty()) {
            return ResData.failure("暂无公告信息");
        } else {
            return ResData.success(list, "获取当年公告信息成功");
        }
    }

    //    获取当年公告信息
    @GetMapping("/getDefaultAnnouncement")
    public ResData<List<Announcement>> getDefaultAnnouncement() {
        QueryWrapper<Announcement> wrapper = new QueryWrapper<>();
        wrapper.eq("year", new Date().getYear() + 1900);
        List<Announcement> list = announcementService.list(wrapper);
        if (list.isEmpty()) {
            return ResData.failure("暂无公告信息");
        } else {
            return ResData.success(list, "获取当年公告信息成功");
        }
    }

    //    添加公告
    @PostMapping("/addAnnouncement")
    public ResData<String> addAnnouncement(@RequestBody Announcement announcement) {
        announcementService.save(announcement);
        return ResData.success("添加公告成功");
    }

    //    删除公告
    @DeleteMapping("/deleteAnnouncement/{id}")
    public ResData<String> deleteAnnouncement(@PathVariable Integer id) {
        announcementService.removeById(id);
        return ResData.success("删除公告成功");
    }
}

