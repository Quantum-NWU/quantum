package com.nwu.quantum.controller;

import com.nwu.quantum.entity.User;
import com.nwu.quantum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@RequestMapping(value = {"/qc"})
@Controller
public class UserController {
    @Autowired
    UserService userService;
    /**
     * 跳转到登录测试页面
     * @return 登录页面
     */
    @RequestMapping(value = {"user/loginPage"})
    public String loginPage(){
        return "user/login";
    }


    /**
     * 跳转到注册测试页面
     * @return 注册页面
     */
    @RequestMapping(value = {"user/registerPage"})
    public String RegisterPage(){
        return "user/register";
    }


    @RequestMapping(value = {"user/register"})
    @ResponseBody
    public String register(String email, String password)
    {
        int count = userService.register(email,password);
        if (count == 0) {
            return "注册失败！";
        }
        else {
            return "注册成功！";
        }
    }

    @RequestMapping(value = {"user/login"})
    @ResponseBody
    public String login(String email,String password) {
        User userInfo = userService.login(email, password);
        if (userInfo == null) {
            return "登录失败";
        } else {
            System.out.println("用户信息为：" + userInfo.getEmail() + " " + userInfo.getPassword());
            return "登录成功";
        }
    }
}