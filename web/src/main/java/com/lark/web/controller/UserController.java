package com.lark.web.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lark.web.model.User;
import com.lark.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Wrapper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2021-08-11
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("getAll")
    public Map<String, Object> getAll() {
        Map<String, Object> map = new HashMap<>();
        List<User> list = userService.list();
        map.put("userList", list);
        return map;
    }

    @PostMapping("query")
    public Map<String, Object> query() {
        Map<String, Object> map = new HashMap<>();
        QueryWrapper<User> queryWrapper = new QueryWrapper();
        List<User> list = userService.list(queryWrapper.like("name", "r"));
        map.put("userList", list);
        return map;
    }

    @PostMapping("insUser")
    public Map<String, Object> insUser() {
        Map<String, Object> map = new HashMap<>();
        userService.testTransaction();
        return map;
    }

    @PostMapping("testSession")
    public Map<String, Object> testSession(HttpServletRequest request, HttpServletResponse response) {
        System.out.println(request.getSession().toString());
        request.getSession().invalidate();
        System.out.println(request.getSession());
        return null;
    }



}


