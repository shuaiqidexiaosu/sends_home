package com.sjy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sjy.entity.User;
import com.sjy.mapper.UserMapper;
import com.sjy.service.UserService;
import org.springframework.stereotype.Service;

/**
* @author sjy85
* @description 针对表【user】的数据库操作Service实现
* @createDate 2024-05-20 15:35:48
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




