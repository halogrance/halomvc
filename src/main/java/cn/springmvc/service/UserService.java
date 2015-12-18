package cn.springmvc.service;

import cn.springmvc.model.User;

public interface UserService {
	
public User login(String name,String passwd);
public int register(User user); 
public int updateUser(User user);
public User CheckLogin(User user);
}
