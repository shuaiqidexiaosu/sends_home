package com.sjy.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sjy.entity.User;
import com.sjy.res.ResData;
import com.sjy.service.UserService;
import com.sjy.utils.JwtTokenUtil;
import com.sjy.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/user")
@Cacheable( "user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisUtil redisUtil;

    // 登陆接口
    @PostMapping("/login")
    public ResData<User> login(@RequestBody User user) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
//        这边登陆是要用学号来登录的,这是例外
        wrapper.eq("user_id", user.getUserId());
        wrapper.eq("password", user.getPassword());
        User res = userService.getOne(wrapper);
        System.out.println("res:" + res);
        if (res != null) {
            String token = JwtTokenUtil.createToken(user);
            return ResData.success(res, token, "登陆成功");
        } else {
            return ResData.failure("登陆失败");
        }
    }

    //    添加成员
    @PostMapping("/addUser")
    public ResData<String> addUser(@RequestBody User user) {
        // 判断用户是否已经存在
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("id", user.getId());
        if (userService.getOne(wrapper) == null) {
            userService.save(user);
            return ResData.success("添加成员成功");
        } else {
            return ResData.failure("添加成员失败，用户已存在");
        }
    }

    //    修改成员
    @PutMapping("/updateUser")
    public ResData<String> updateUser(@RequestBody User user) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("id", user.getId());
        if (userService.getOne(wrapper) != null) {
            userService.update(user, new QueryWrapper<User>().eq("id", user.getId()));
            return ResData.success("修改成员成功");
        } else {
            return ResData.failure("修改成员失败，用户不存在");
        }
    }

    //    删除成员
    @DeleteMapping("/deleteUser/{id}")
    public ResData<String> deleteUser(@PathVariable("id") Integer id) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("id", id);
        if (userService.getOne(wrapper) != null) {
            userService.removeById(id);
            return ResData.success("删除成员成功");
        } else {
            return ResData.failure("删除成员失败，用户不存在");
        }
    }

    //    获取自己数据接口
    @GetMapping("/getMyData/{id}")
    public ResData<User> getMyData(@PathVariable("id") Integer id) {
        String data_key = "user_data_" + id;
        if (redisUtil.hasKey(data_key)) {
            return (ResData<User>) redisUtil.get(data_key);
        } else {
            QueryWrapper<User> wrapper = new QueryWrapper<>();
            wrapper.eq("id", id);
            User user = userService.getOne(wrapper);
            System.out.println(user);
            if (user != null) {
                redisUtil.set(data_key, ResData.success(user, "获取个人中心数据成功"));
                return ResData.success(user, "获取个人中心数据成功");
            } else {
                return ResData.failure("获取个人中心数据失败，用户不存在");
            }
        }
    }


    // 获取桑梓成员数据接口
    @GetMapping("/getDefaultUserData")
    public ResData<List<User>> getDefaultUserData() {
        String data_key = "DefaultUserData";
        if (redisUtil.hasKey(data_key)) {
            return (ResData<List<User>>) redisUtil.get(data_key);
        } else {
            Date date = new Date(); // this object contains the current date value
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
            int current_year = Integer.parseInt(formatter.format(date));
            QueryWrapper<User> wrapper = new QueryWrapper<>();
            wrapper.between("session", current_year - 4, current_year).or().eq("position", "老师");
            List<User> list = userService.list(wrapper);
            if (list != null) {
                redisUtil.set(data_key, ResData.success(list, "获取桑梓成员数据成功"));
                return ResData.success(list, "获取桑梓成员数据成功");
            } else {
                return ResData.failure("获取桑梓成员数据失败");
            }
        }
    }


    @GetMapping("/getUserDataByYear/{year}")
    public ResData<List<User>> getUserDataByYear(@PathVariable("year") Integer year) {
        String data_key = "UserDataByYear_" + year;
        if (redisUtil.hasKey(data_key)) {
            return (ResData<List<User>>) redisUtil.get(data_key);
        } else {
            QueryWrapper<User> wrapper = new QueryWrapper<>();
            wrapper.eq("session", year);
            List<User> list = userService.list(wrapper);
            if (list != null) {
                redisUtil.set(data_key, ResData.success(list, "获取用户数据成功"));
                return ResData.success(list, "获取用户数据成功");
            } else {
                return ResData.failure("获取用户数据失败，用户不存在");
            }
        }

    }


    //    获取特定部门桑梓成员数据接口
    @GetMapping("/getDepartmentUserData/{department}")
    public ResData<List<User>> getDepartmentUserData(@PathVariable("department") String department) {
        String data_key = "DepartmentUserData" + department;
        if (redisUtil.hasKey(data_key)) {
            return (ResData<List<User>>) redisUtil.get(data_key);
        } else {
            Date date = new Date(); // this object contains the current date value
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
            int current_year = Integer.parseInt(formatter.format(date));
            QueryWrapper<User> wrapper = new QueryWrapper<>();
            wrapper.between("session", current_year - 4, current_year);
            wrapper.eq("department", department);
            List<User> list = userService.list(wrapper);
            if (list != null) {
                redisUtil.set(data_key, ResData.success(list, "获取特定部门桑梓成员数据成功"));
                return ResData.success(list, "获取特定部门桑梓成员数据成功");
            } else {
                return ResData.failure("获取特定部门桑梓成员数据失败，用户不存在");
            }
        }

    }

    @GetMapping("/getDepartmentUserDataByYear/{department}/{year}")
    public ResData<List<User>> getDepartmentUserDataByYear(@PathVariable("department") String department, @PathVariable("year") Integer year) {
        String data_key = "DepartmentUserDataByYear_" + department + "_" + year;
        if (redisUtil.hasKey(data_key)) {
            return (ResData<List<User>>) redisUtil.get(data_key);
        } else {
            QueryWrapper<User> wrapper = new QueryWrapper<>();
            wrapper.eq("session", year);
            wrapper.eq("department", department);
            List<User> list = userService.list(wrapper);
            if (list != null) {
                redisUtil.set(data_key, ResData.success(list, "获取用户数据成功"));
                return ResData.success(list, "获取用户数据成功");
            } else {
                return ResData.failure("获取用户数据失败，用户不存在");
            }
        }
    }
}
