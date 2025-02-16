package com.itbaima;


import com.itbaima.config.SpringConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 用于配置类的演示说明使用
 */
public class ApplicationContextTest2 {
    public static void main(String[] args) {
//        之前是获取配置文件，然后进行操作，现在要演示获取配置类，然后进行操作
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        System.out.println(context.getBean("userDao"));
    }
}

