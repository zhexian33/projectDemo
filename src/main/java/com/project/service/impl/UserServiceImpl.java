package com.project.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.project.mapper.UserMapper;
import com.project.pojo.User;
import com.project.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
