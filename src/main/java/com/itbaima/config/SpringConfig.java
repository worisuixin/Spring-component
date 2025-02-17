package com.itbaima.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.itbaima.beans.OtherBean;
import com.itbaima.imports.MyImportSelector;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;

@Configuration //标注当前类是一个配置类（替代配置文件）+@Component.这个注解本身就有Component，所以不用写，spring就会管理
//        <context:component-scan base-package="com.itbaima"/>，原来这是用来扫描包的，现在不用了，换成：
@ComponentScan("com.itbaima") //点开可以发现，这是个数组，表明你可以放入多个包的路径。只有一个就不写，多个就写个大括号
//      <context:property-placeholder location="classpath:jdbc.properties" 用于指明属性json的位置，也可以用：
@PropertySource("classpath:jdbc.properties")  //同理，这也是个数组，表明可以放入多个需要扫描的文件
//     <import resource= "classpath:beans.xml"/>  用于去加载其他配置类   换成这样：
@Import(OtherBean.class)     //现在使用这个import，就可以直接在这里写，那么OtherBean本身就不需要写@Component， 第一种导入类型
// 因为这个配置类肯定会被注册的，不需要注解声明，就可以注册方法获取的bean

//@Import(MyImportSelector.class) import的第二种导入类型，实现Importseletor接口的类。这个是数组，所以不能同时存在两个Import
//Mapper的组件扫描
@MapperScan("com.itbaima.mapper")
public class SpringConfig {

    @Bean //这样就实现了注入，不写默认就是这个方法名作为BeanName  非自定义，即自动注入
    public DataSource dataSource(
            @Value("${jdbc.driver}") String driver,
            @Value("${jdbc.url}") String url,
            @Value("${jdbc.username}") String username,
            @Value("${jdbc.password}") String password     //这样就可以直接使用property里面的json键值对
    ) {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean
    SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource) {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean;
    }
    //注解方式整合第三方框架
    //以上两个Bean就是对配置文件整合Mybatis的替换，第一个实现了配置datasource，第二个实现了配置SqlSessionFactoryBean。
    // 上面的MApperScan则实现了第三个的扫描mapper文件
}
