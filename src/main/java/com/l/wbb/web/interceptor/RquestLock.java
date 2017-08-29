package com.l.wbb.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.l.wbb.bean.User;

public class RquestLock implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String uri = request.getRequestURI();
		uri = uri.substring(uri.lastIndexOf("/")+1);
		
		if(uri.equals("setLikeInfo")||
				uri.equals("publishInfo")||
				uri.equals("publishComment")){
			HttpSession session = request.getSession();
			boolean token = (Boolean) session.getAttribute(uri)==null?true:(Boolean) session.getAttribute(uri);
			LogManager.getLogger().debug("对请求进行令牌判断... 用户："+((User) session.getAttribute("user")) + "  请求地址："+uri+" token："+token);
			if(token){
				session.setAttribute(uri, false);
				return true;
			}else{
				return false;
			}
				
			
		}
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		String uri = request.getRequestURI();
		uri = uri.substring(uri.lastIndexOf("/")+1);
		if(uri.equals("setLikeInfo")||
				uri.equals("publishInfo")||
				uri.equals("publishComment")){
			request.getSession().setAttribute(uri, true);
		}
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
	}

}
