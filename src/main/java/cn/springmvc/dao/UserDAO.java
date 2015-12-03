package cn.springmvc.dao;

import cn.springmvc.model.User;

public interface UserDAO {
public int insertUser(User user);
//public User selectAll();
public int deleteUser(int id);
public int updateUser(User user);
}
