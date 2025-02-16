package com.itbaima.config;

import com.itbaima.beans.OtherBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration //标注当前类是一个配置类（替代配置文件）+@Component.这个注解本身就有Component，所以不用写，spring就会管理
//        <context:component-scan base-package="com.itbaima"/>，原来这是用来扫描包的，现在不用了，换成：
@ComponentScan("com.itbaima") //点开可以发现，这是个数组，表明你可以放入多个包的路径。只有一个就不写，多个就写个大括号
//      <context:property-placeholder location="classpath:jdbc.properties" 用于指明属性json的位置，也可以用：
@PropertySource("classpath:jdbc.properties")  //同理，这也是个数组，表明可以放入多个需要扫描的文件
//     <import resource= "classpath:beans.xml"/>  用于去加载其他配置类   换成这样：
@Import(OtherBean.class)     //现在使用这个import，就可以直接在这里写，那么OtherBean本身就不需要写@Component，
// 因为这个配置类肯定会被注册的，不需要注解声明，就可以注册方法获取的bean
public class SpringConfig {
}
