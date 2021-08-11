package com.lark.web.controller;


import com.lark.web.model.User;
import com.lark.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

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

}

