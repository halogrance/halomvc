package cn.springmvc.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class AllIntercepter implements HandlerInterceptor{
	private Logger log = LoggerFactory.getLogger(AllIntercepter.class);
/*//3
	public void afterCompletion(WebRequest request, Exception e) throws Exception {
		System.out.println(e+"===========================");
		
		
	}
//2
	public void postHandle(WebRequest request, ModelMap map) throws Exception {
		long startTime = (Long) request.getAttribute("startTime");
		long endTime = System.currentTimeMillis();
		long executeTime = endTime - startTime;
		log.info("[" + handler + "] executeTime : " + executeTime + "ms");
//		for (String key:map.keySet()) {
//			System.out.println(key+"。。。。。。。。。。。。。。");
//			map.put("name3", "value3");
//			map.put("name1", "name1");
//		}
		
	}
//1
	
	public void preHandle(WebRequest request) throws Exception {
		long startTime = System.currentTimeMillis();
		request.setAttribute("startTime", startTime,WebRequest.SCOPE_REQUEST);
		
//		System.out.println("AllIntercepter........................");
//		request.setAttribute("request", "request",WebRequest.SCOPE_REQUEST);
//		request.setAttribute("session", "session", WebRequest.SCOPE_SESSION);
//		request.setAttribute("globalSession", "globalSession", WebRequest.SCOPE_GLOBAL_SESSION);
	}*/
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		long startTime = System.currentTimeMillis();
		request.setAttribute("startTime", startTime);
		return true;
	}
	public void postHandle(HttpServletRequest request, HttpServletResponse arg1, Object handler, ModelAndView arg3)
			throws Exception {
		long startTime = (Long) request.getAttribute("startTime");
		long endTime = System.currentTimeMillis();
		long executeTime = endTime - startTime;
		log.info("[" + handler + "] executeTime : " + executeTime + "ms");
		
	}
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
