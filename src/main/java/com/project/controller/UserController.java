package com.project.controller;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.project.command.R;
import com.project.pojo.User;
import com.project.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    //注册
    @PostMapping
    public R<String> add(@RequestBody User user){
        userService.save(user);
        return R.success("注册成功");
    }
    //查询全部
    @GetMapping("/page")
    public R<List<User>> getList(){
        List<User> list = userService.list();
        return R.success(list);
    }
    //根据id查询
    @GetMapping("/{id}")
    public R<User> getById(@PathVariable int id){
        User user = userService.getById(id);
        return R.success(user);
    }
    //登陆
    @PostMapping("/login")
    public R<User> login(HttpServletRequest httpServletRequest,@RequestBody User user){
        System.out.println(user);
        LambdaQueryWrapper<User> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUsername,user.getUsername());
        User one = userService.getOne(queryWrapper);
        if(one==null||!one.getPassword().equals(user.getPassword())){
            return R.error("登陆失败");
        }
        httpServletRequest.getSession().setAttribute("user",one.getId());
        return R.success(user);
    }
}
