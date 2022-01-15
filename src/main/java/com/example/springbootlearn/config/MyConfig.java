package com.example.springbootlearn.config;


import ch.qos.logback.core.db.DBHelper;
import com.example.springbootlearn.bean.Pet;
import com.example.springbootlearn.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 1.配置类里面使用@bean标注在方法上给容器注册组件，默认也是单例的
 * 2.配置类本身也是组件
 * 3.proxyBeanMethods,代理bean的方法
 * proxyBeanMethods = true
 * 组件依赖必须使用true
 *
 * 4.@Import({User.class,Pet.class})
 *   给容器中自动创建这俩个类型的组件，默认组件的名字就是全类名
 *
 */

@Import({User.class, DBHelper.class})
@Configuration(proxyBeanMethods = true) //告诉springboot这是一个配置类 == 配置文件
public class MyConfig {

    //外部无论对配置类中的这个组件注册方法调用多少次获取的都是之前注册容器中的单实例
    @Bean//给容器中添加组件，以方法名作为组建的id，返回类型就是组件类型，返回的值就是组件在容器中的实例
    public User user01(){
        User user = new User("张三", 20);
        user.setPet(pet01());
        return user;
    }

    @Bean("tom")  //自定义组件名
    public Pet pet01(){
        return new Pet("tomcat");
    }
}
