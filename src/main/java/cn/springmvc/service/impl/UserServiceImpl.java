package cn.springmvc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import cn.springmvc.dao.UserDAO;
import cn.springmvc.model.User;
import cn.springmvc.service.UserService;

@Service(value="UserServiceImpl")
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDAO userDAO;

	public int insertUser(User user) {
		// TODO Auto-generated method stub
		return userDAO.insertUser(user);
	}

//	public User selectAll() {
//		// TODO Auto-generated method stub
//		return userDAO.selectAll();
//	}

	public int deleteUser(int id) {
		// TODO Auto-generated method stub
		return userDAO.deleteUser(id);
	}

	public int updateUser(User user) {
		// TODO Auto-generated method stub
		return userDAO.updateUser(user);
	}

}
