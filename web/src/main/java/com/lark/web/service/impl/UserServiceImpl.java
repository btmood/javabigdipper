package com.lark.web.service.impl;

import com.lark.web.model.User;
import com.lark.web.mapper.UserMapper;
import com.lark.web.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2021-08-11
 */
@Service
@Transactional
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Pointcut("execution(* com.lark.web.service.impl.UserServiceImpl.testTransaction())")
    @Override
    public void testTransaction() {
        User user = new User();
        user.setName("anke");
//        try {
//            System.out.println(4/0);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        baseMapper.insert(user);
    }
}
