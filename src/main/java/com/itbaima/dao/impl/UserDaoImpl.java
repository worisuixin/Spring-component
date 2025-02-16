package com.itbaima.dao.impl;

import com.itbaima.dao.UserDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//@Component("userDao")  //当注解只有一个属性，且这个属性值为value时，就不需要写value。这个就是bean name也就是原本bean标签的id
@Repository("userDao")  //这个Repository其实和Component是一样的效果，只是说这里方便理解，表明这是DAO层的类
@Scope("singleton")
@Lazy(true)
public class UserDaoImpl implements UserDao {
    @Value("zhangsi")  //这个也可以放在set方法中去使用，也可以生效。不过这一般是用于键值对的引入
    private String username;

    @Override
    public void show() {
        System.out.println(username);
    }

    public UserDaoImpl() {
        System.out.println("UserDaoImpl创建");
    }

    @PostConstruct   //之前的在bean的标签配置中表明哪一个是init方法，哪一个是销毁方法，这个直接加一个注解就完事了
    public void init() {
        System.out.println("UserDao的初始化方法");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("UserDao的销毁方法");
    }

}
