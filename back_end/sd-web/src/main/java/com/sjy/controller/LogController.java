package com.sjy.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sjy.entity.Log;
import com.sjy.res.ResData;
import com.sjy.service.LogService;
import com.sjy.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/log")
public class LogController {


    @Autowired
    private LogService logService;

    @Autowired
    private RedisUtil redisUtil;

    //
    @GetMapping("/getLogs")
    public ResData<List<Log>> getLogs() {
        String data_key = "Logs";
        if (redisUtil.hasKey(data_key)) {
            return (ResData<List<Log>>) redisUtil.get(data_key);
        } else {
            QueryWrapper<Log> wrapper = new QueryWrapper<>();
            wrapper.select("id", "content", "time", "year");
            List<Log> list = logService.list(wrapper);
            if (list.isEmpty()) {
                return ResData.failure("暂无日志信息");
            } else {
                redisUtil.set(data_key, ResData.success(list, "获取当年日志信息成功"));
                return ResData.success(list, "获取当年日志信息成功");
            }
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
