package cn.springmvc.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.springmvc.model.User;
import cn.springmvc.service.UserService;
import cn.springmvc.service.impl.UserServiceImpl;

public class UserTest {
private UserService userService;
@Before
public void before(){
	@SuppressWarnings("resource")
	ApplicationContext context=new ClassPathXmlApplicationContext(new String[]{"classpath:conf/spring-mybatis.xml"});
	userService=(UserServiceImpl)context.getBean("UserServiceImpl");
}
@Test
public void addUser(){
	User user=new User();
	user.setNickname("���");
	user.setState(2);
	System.out.println(userService.insertUser(user));
}
//@Test
//public void selectUser(){
//	User user=userService.selectAll();
//	System.out.println(user.getNickname());
//}
//@Test
//public void selectUser(){
//	userService.deleteUser(1);
//}
//@Test
//public void selectUser(){
//	User user=new User();
//	user.setId(1);
//	user.setNickname("halo");
//	userService.updateUser(user);
//}
}
