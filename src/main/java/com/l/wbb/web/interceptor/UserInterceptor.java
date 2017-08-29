package com.l.wbb.web.interceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class UserInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String uri = request.getRequestURI();
		uri = uri.substring(uri.lastIndexOf("/")+1);
		
		if(		uri.equals("enterPublish")
				||uri.equals("userHistory") ){
			LogManager.getLogger().debug("对 "+uri+" 进行用户登录拦截操作...");
			if(request.getSession().getAttribute("user") == null){
				response.sendRedirect("/wbb/index.jsp");
				return false;
			}
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

}
