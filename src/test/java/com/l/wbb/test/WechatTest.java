package com.l.wbb.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.l.wbb.service.UserService;
import com.l.wbb.service.impl.UserServiceImpl;

import net.sf.json.JSONObject;

public class WechatTest {
	static UserService userService;
	static{
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
		userService = (UserService) ac.getBean("userService");
	}
	@Test
	public void testInit(){
		//UserServiceImpl u = new UserServiceImpl();
		//System.out.println(u.getAccessToken().getString("access_token"));
		//String access_token = u.getAccessToken().getString("access_token");
		//JSONObject jo = u.getJsApiTicket("_ygShsSPX3zCNPPDOPb_akQi-Vj0GX0HsHQA5hb6hH8KzXi_6HcnJmYOG5nA3IanvLT4Ab-HQkCc98Wr5-kF24kFwUnGSi5f6vxa6-fgS9pnY_UQ-bpDu7QMFJbOH9xhARAiAHAGXG");
		//System.out.println(jo.getString("ticket"));
		System.out.println(userService.initJs());
	}
	
}
