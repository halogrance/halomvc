package cn.springmvc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import cn.springmvc.dao.UserDAO;
import cn.springmvc.model.User;
import cn.springmvc.service.UserService;

@Service(value="UserServiceImpl")
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDAO userDAO;

	public User login(String name,String passwd) {
		User user=new User();
		user.setUserName(name);
//		user.setUserPass(passwd);
		User Checkuser=userDAO.CheckLogin(user);
		if (Checkuser!=null) {
			if (DigestUtils.md5DigestAsHex(passwd.getBytes()).equals(Checkuser.getUserPass())) {
				Checkuser.setLoginTime(System.currentTimeMillis());
				userDAO.updateUser(Checkuser);
				return Checkuser;
			}
		}
		
		return null;
	}

	public int register(User user) {
		int i =userDAO.register(user);
		return i;
	}

	public int updateUser(User user) {
		userDAO.updateUser(user);
		return 0;
	}

	public User CheckLogin(User user) {
		// TODO Auto-generated method stub
		return userDAO.CheckLogin(user);
	}



}
