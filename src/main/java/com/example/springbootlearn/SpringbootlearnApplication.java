package com.example.springbootlearn;

import com.example.springbootlearn.bean.Pet;
import com.example.springbootlearn.bean.User;
import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringbootlearnApplication {

	public static void main(String[] args) {
		//1.返回ioc容器
		ConfigurableApplicationContext run = SpringApplication.run(SpringbootlearnApplication.class, args);
		System.out.println("hello springboot");

		int i = Runtime.getRuntime().availableProcessors();//cpu核数
		System.out.println(i);
		//2.查看容器里面的组件
		String[] beanDefinitionNames = run.getBeanDefinitionNames();
		for (String beanDefinitionName : beanDefinitionNames) {
			System.out.println(beanDefinitionName);
		}
		//3.从容器中获取组件
		Pet tom = run.getBean("tom", Pet.class);
		System.out.println(tom);
		System.out.println("===================================================");
		User user = run.getBean("user01", User.class);
		System.out.println(user.getPet()==tom);


	}

	@Test
	public void testCoditional(){
		ConfigurableApplicationContext run = SpringApplication.run(SpringbootlearnApplication.class);
		boolean user01 = run.containsBean("user01");
		System.out.println("容器中包含user01："+user01);
	}


}
