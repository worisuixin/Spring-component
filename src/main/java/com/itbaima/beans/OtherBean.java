package com.itbaima.beans;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component("otherBean")
public class OtherBean {


    @Bean("dataSource")  //这里要写上@bean，表明这是个非自定义的bean，spring才会去管，且这个括号里面就是返回值的beanName，不写就是方法的名字
//    这样子，就通过这个方法，这个返回值也会被注册为一个Bean
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
//        设置四个基本参数……
        return dataSource;
    }
}
