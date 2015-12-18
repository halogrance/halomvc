package cn.springmvc.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import until.Commonfunction;
import until.DES;
public class RoleFilter implements Filter{

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)arg0;
		HttpServletResponse response = (HttpServletResponse)arg1;
		String url = request.getRequestURL().toString();
//		System.out.println(url+"~~~~~!!@@");
//		if(url.indexOf("page") > 0 && url.indexOf("login") < 0){
			String name="";
			String times="";
			String logintime="";
			Cookie[] cookies=request.getCookies();
			if (cookies!=null) {
				for (int i = 0; i < cookies.length; i++) {
					if (cookies[i].getName().equals("user")) {
					name=cookies[i].getValue().split("-")[0];
					times=cookies[i].getValue().split("-")[1];
					System.out.println(times+"~~~~~~");
					String key="9898989888888888";
//					byte[] loginTimes;
//					String logintime;
//					try {
						try {
							logintime = DES.decrypt(times, key);
							System.out.println(logintime+"~~~~~~");
							long endTime=Commonfunction.fromDateStringToLong(Commonfunction.dqsj());
							long startTime=Commonfunction.fromDateStringToLong(logintime);
							System.out.println(startTime+"@@@@@@@"+endTime);
							 long ss=(endTime-startTime)/(1000); //共计秒数
							 int MM = (int)ss/60;   //共计分钟数
							 System.out.println(ss+"~~~~");
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
//						logintime=new String(loginTimes);
//					} catch (Exception e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					
					}
					
				}
				
			}

//				response.sendRedirect(request.getContextPath()+"/redirect.asp");
//			}else{
			arg2.doFilter(request, response);
//		}
		
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
