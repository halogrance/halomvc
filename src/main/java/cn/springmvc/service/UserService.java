package cn.springmvc.service;

import cn.springmvc.model.User;

public interface UserService {
public int insertUser(User user);
//public User selectAll();
public int deleteUser(int id);
public int updateUser(User user);
}
