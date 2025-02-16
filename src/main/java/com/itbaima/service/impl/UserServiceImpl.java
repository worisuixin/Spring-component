package com.itbaima.service.impl;

import com.itbaima.dao.UserDao;
import com.itbaima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component("userService")  //如果这里啥也不写，会将类名首字母小写当做bean的name
@Service("userService")  //这里的业务层也是更改一下，不使用Component，而使用Service，效果一样
public class UserServiceImpl implements UserService {

    @Autowired  //表示根据类型自动注入        也可以写到set方法之上，效果是一样的
    private UserDao userDao;

    @Override
    public void show() {
        System.out.println(userDao);
    }
}
