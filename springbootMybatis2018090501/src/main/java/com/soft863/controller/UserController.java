package com.soft863.controller;

import com.soft863.quartz.Myjob;
import com.soft863.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
@Transactional
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/one")
    public @ResponseBody List<Map<String, Object>> methodOne(){

        return userService.queryUsers();
    }

    @RequestMapping("/two")
    public ModelAndView methodTwo(){
        ModelAndView mav = new ModelAndView("b");

        userService.delete();
        //测试缓存，redis命令：cmd，redis-cli进入，keys *查询缓存的key,
        //flushdb清空缓存
        //redis安装与配置看redis记录文件

        return mav;
    }

    @RequestMapping("/three")
    public @ResponseBody String methodThree(){

        return "back";
    }
}
