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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import until.Commonfunction;
import until.DES;
public class RedirectFilter implements Filter{
	 private Logger log = LoggerFactory.getLogger("Cookies");
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)arg0;
		HttpServletResponse response = (HttpServletResponse)arg1;
		Cookie[] cookies = request.getCookies();
        String reurl=((HttpServletRequest) request).getContextPath()+"/relogin";
        String key="9898989888888888";
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    try {
                        String token = DES.decrypt(cookie.getValue(),key);
                        long lastTime=Long.valueOf(token.split(",")[1]);
                        long overdue=System.currentTimeMillis()-lastTime;
                        if(overdue < 30*60*1000){
                            reurl=null;
                        }
                    }catch (Exception e){
                        this.log.error("cookie 校验失败，失败原因："+e);
                    }
                    this.log.info("cookies 校验成功！");
                    break;
                }
            }
        }
        if(reurl != null){
            ((HttpServletResponse)response).sendRedirect(reurl);
            return;
        }
			arg2.doFilter(request, response);
		
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
