package com.itbaima.service.impl;

import com.itbaima.dao.UserDao;
import com.itbaima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component("userService")  //如果这里啥也不写，会将类名首字母小写当做bean的name
@Service("userService")  //这里的业务层也是更改一下，不使用Component，而使用Service，效果一样
public class UserServiceImpl implements UserService {

    @Autowired  //表示根据类型自动注入    也可以写到set方法之上，效果是一样的,最终发现其实写在哪里都行，只要参数里面有Bean，就可以自动注入
//    这时候当Autowired自动注入，有同一个类型，但是名字不同的话，应该会报错，但没有。它会首先根据类型匹配
//    匹配失败之后再根据名字匹配，寻找名字匹配的那一个，再找不到则报错。  这里这个userdao名字就有匹配的，所以可以正确匹配

    @Qualifier("userDao")  //也可以和Qualifier配合使用，直接在Autowired下面写上这个标签，直接指定名字。
    private UserDao userDao;

    @Override
    public void show() {
        System.out.println(userDao);
    }
}
