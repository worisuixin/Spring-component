package com.itbaima.imports;

import com.itbaima.beans.OtherBean2;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 用于演示import导入
 */
public class MyImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
//        参数AnnotationMetadata是 Spring 注解的元数据对象，包含了注解的信息，例如注解所在的类、注解的属性等。
//        该对象内部封装是当前使用了  @Import注解的类上的  其他注解的源信息  ，可以用它去获取到

//        返回的数组封装的是需要被注册到Spring容器中的Bean的全限定名。这里直接将需要注册的Bean的全限定名放到这个数组里面就完成了注册
        return new String[]{OtherBean2.class.getName()};  //这样之后，就可以获取到了
    }
}
