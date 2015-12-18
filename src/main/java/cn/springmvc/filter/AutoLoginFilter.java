//package cn.springmvc.filter;
//
//import java.io.IOException;
//import java.security.MessageDigest;
//
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.alibaba.druid.util.Base64;
//
//import cn.springmvc.model.User;
//import cn.springmvc.service.impl.UserServiceImpl;
//import sun.misc.BASE64Encoder;
//
//public class AutoLoginFilter implements Filter{
//
//	public void destroy() {
//		// TODO Auto-generated method stub
//		
//	}
//	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
//			throws IOException, ServletException {
//		// TODO Auto-generated method stub
//		//第一步造型
//		HttpServletRequest request=(HttpServletRequest)req;
//		HttpServletResponse response=(HttpServletResponse)res;
//		//1.首先判断session中有没有admin
//		Object object=request.getSession().getAttribute("user");
//		System.out.println(object+"---*-*-*-*");
//		if (object!=null) {
//			request.getRequestDispatcher("/student").forward(request, response);
//			return;
//		}
//		//第二步 判断cookie 中是否存在
//		Cookie autoCookie=null;
//		Cookie cookies[]=request.getCookies();
//		if (cookies!=null) {
//			//遍历cookie
//			for (Cookie cookie:cookies) {
//				//判断cookie中是否有autologin 标示符的cookie
//				if ("user".equals(cookie.getName())) {
//					autoCookie=cookie;//赋值
//				}
//			}
//			System.out.println("--------"+autoCookie+"-------");
//			//判断cookie中是否有
//			if (autoCookie!=null) {
//				chain.doFilter(request, response);
//				return;
//			}
//			System.out.println("+++++++"+autoCookie);
//			//判断cookie的值
//			//获取cookie的值
//			String value=autoCookie.getValue();
//			//拆分
//			String temp[]=value.split("-");
//			System.out.println("length........"+temp.length);
//			//判断长度对否，等于自己拼凑的长度
//			if (temp.length!=3) {
//				chain.doFilter(request, response);
//				return;
//			}
//			String name=temp[0];
//			String time=temp[1];
////			String service_md5Value=temp[2];
//			System.out.println(Long.valueOf(time)+"---时间----"+System.currentTimeMillis());
//			//判断是否失效
//			if (Long.valueOf(time)<=System.currentTimeMillis()) {
//				chain.doFilter(request, response);
//				return;
//			}
//			//根据用户名去查询用户
//			UserServiceImpl userServiceImpl=new UserServiceImpl();
//			//查询用户
//			User u=new User();
//			u.setUserName(name);
//			User user=userServiceImpl.CheckLogin(u);
//			System.out.println("----重新查询---"+user.toString());
//			if (user==null) {
//				chain.doFilter(request, response);
//				return;
//			}
//			//拼接的字符
////			String md5Temp=user.getUserName()+":"+user.getUserPass()+":"+time;
////			System.out.println(md5Temp+"---"+service_md5Value);
////			if (!(md5Value(md5Temp).equals(service_md5Value))) {
////				chain.doFilter(request, response);
////				return;
////			}
//			request.getSession().setAttribute("user", user);
//			request.getRequestDispatcher("/student").forward(request, response);
//		}else {
//			chain.doFilter(request, response);
//			return;
//		}
//		
//	}
//
//	public void init(FilterConfig arg0) throws ServletException {
//		// TODO Auto-generated method stub
//		
//	}
//	public String md5Value(String value){
//		try {
//			MessageDigest digest=MessageDigest.getInstance("md5");
//			byte result[]=digest.digest(value.getBytes());
//			BASE64Encoder encoder=new BASE64Encoder();
//			return encoder.encode(result);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return "";
//	}
//
//}
