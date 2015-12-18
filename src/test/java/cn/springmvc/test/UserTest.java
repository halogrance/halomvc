package cn.springmvc.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.springmvc.dao.UserDAO;
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
	UserDAO userDAO;
	
}
@Test
public void addUser(){
//	User user=new User();
//	user.setNickname("���");
//	user.setState(2);
//	System.out.println(userService.insertUser(user));
}
@Test
public void selectUser(){
	User user=new User();
	user.setUserName("halo");
	user.setLoginTime(System.currentTimeMillis());
	userService.updateUser(user);
}
@Test
public void selectUser1(){
	User user=new User();
	user.setUserName("halo");
	userService.CheckLogin(user);
}
//@Test
//public void selectUser(){
//	User user=new User();
//	user.setId(1);
//	user.setNickname("halo");
//	userService.updateUser(user);
//}
}
