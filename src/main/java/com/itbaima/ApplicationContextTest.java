package com.itbaima;

import com.itbaima.dao.UserDao;
import com.itbaima.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao bean = context.getBean(UserDao.class);
        bean.show();
        System.out.println(bean);

        UserService userService = (UserService)context.getBean("userService");
        userService.show();
        context.close();  //会销毁所有的bean，一旦销毁就会执行bean特有的销毁前的方法
    }
}
