package cn.springmvc.controller;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;


import cn.springmvc.model.User;
import cn.springmvc.service.impl.UserServiceImpl;
import until.DES;

@Controller
public class UserControll {
	@Autowired
	UserServiceImpl userServiceImpl;
	@RequestMapping(value = "/userinfo/loginUser")
	public String postStudent(String name,String passwd,HttpServletRequest request,HttpServletResponse response) {
		User users=userServiceImpl.login(name,passwd);
		String key="9898989888888888";
		if (users!=null) {
			String user = String.valueOf(users.getId()) + "," + String.valueOf(users.getLoginTime());
            Cookie cookie = new Cookie("token", DES.encrypt(user,key));
            cookie.setMaxAge(30 * 60);
            cookie.setPath(request.getContextPath());
            response.addCookie(cookie);
            return "redirect:/u/student";
		}
//		String checked=request.getParameter("checked");
//		System.out.println(user.getUserName()+"~~"+user.getUserPass()+checked);
//		String userName=user.getUserName();
//		String pwd=user.getUserPass();
//		String loginTime=new Date().toLocaleString();;
//		System.out.println(String.valueOf(loginTime)+"~!@#######");
//		String key="9898989888888888";
//		String names=DES.encrypt(userName, key);
//		String loginTimes=DES.encrypt(loginTime, key);
//		System.out.println(names+"-"+loginTimes+"~~~~~");
//		if ("on".equals(checked)) {
//			Cookie cookieuser=new Cookie("user", names+"-"+loginTimes);
//			cookieuser.setMaxAge(60);
////			cookieuser.setPath("/");
////			cookieuser.setDomain(".cl.org");
//			response.addCookie(cookieuser);
//		}
//		String url="/stuent";
		
//		String name="";
//		String times="";
//		Cookie[] cookies=request.getCookies();
//		if (cookies!=null) {
//			for (int i = 0; i < cookies.length; i++) {
//				if (cookies[i].getName().equals("user")) {
//					name=cookies[i].getValue().split("-")[0];
//					times=cookies[i].getValue().split("-")[1];
//					String key="9898989888888888";
//					byte[] names=DES.encrypt(name.getBytes(), key);
//					byte[] loginTimes=DES.encrypt(times.getBytes(), key);
//					request.setAttribute("name", names);
//					request.setAttribute("loginTime", loginTimes);
//					System.out.println(name+times+"@#$~~~");
////					if (userName.equals("222")&&loginTime.equals("333")) {
////						return"redirect:/student";
////					}
//				}
//				
//			}
//		}
//		student.setCreateAt(System.currentTimeMillis());
//		this.studentServiceImpl.insertStu(student);
		return "/login";
		
	}
	@RequestMapping(value = "/userinfo/registerUser")
	public String userRegister(User user){
		String userpass=DigestUtils.md5DigestAsHex(user.getUserPass().getBytes());
		String userpass2=DigestUtils.md5DigestAsHex(user.getUserPass2().getBytes());
		user.setUserPass(userpass);
		user.setUserPass2(userpass2);
		userServiceImpl.register(user);
		return"redirect:/u/student";
	}
}
