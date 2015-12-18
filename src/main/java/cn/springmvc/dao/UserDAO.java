package cn.springmvc.dao;

import cn.springmvc.model.User;

public interface UserDAO {
public int login(User user);
public int updateUser(User user);
public int register(User user);
public User CheckLogin(User user);
}
