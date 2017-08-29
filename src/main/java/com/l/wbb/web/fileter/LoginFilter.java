package com.l.wbb.web.fileter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;

@WebFilter("/page/user/*")

public class LoginFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		LogManager.getLogger().debug("需要检查用户界面过滤器初始化..");
	}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		LogManager.getLogger().debug("进行用户是否登陆过滤..");
		if(((HttpServletRequest)request).getSession().getAttribute("user")==null){
			LogManager.getLogger().debug("用户未登陆..");
			((HttpServletResponse) response).sendRedirect("/center/enter");
		}
	}

	@Override
	public void destroy() {
		LogManager.getLogger().debug("需要检查用户界面过滤器销毁了..");
	}

}
