package com.sjy.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sjy.entity.Announcement;
import com.sjy.entity.Log;
import com.sjy.entity.User;
import com.sjy.res.ResData;
import com.sjy.service.AnnouncementService;
import com.sjy.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/log")
public class LogController {


    @Autowired
    private LogService logService;

    //
    @GetMapping("/getLogs")
    public ResData<List<Log>> getLogs() {
        QueryWrapper<Log> wrapper = new QueryWrapper<>();
        wrapper.select("id", "content", "time","year");
        List<Log> list = logService.list(wrapper);
        if (list.isEmpty()) {
            return ResData.failure("暂无公告信息");
        } else {
            return ResData.success(list, "获取当年公告信息成功");
        }
    }

    //    添加日志
    @PostMapping("/addLog")
    public ResData<String> addLog(@RequestBody Log log) {
        logService.save(log);
        return ResData.success("添加公告成功");
    }

    //    删除日志
    @DeleteMapping("/deleteLog/{id}")
    public ResData<String> deleteLog(@PathVariable Integer id) {
        logService.removeById(id);
        return ResData.success("删除公告成功");
    }
}
