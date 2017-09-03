package com.l.wbb.test;

import java.util.Iterator;
import java.util.Set;

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
		UserServiceImpl u = new UserServiceImpl();
		//System.out.println(u.getAccessToken().getString("access_token"));
		//String access_token = u.getAccessToken().getString("access_token");
		JSONObject jo = u.getJsApiTicket("Z8cxh6MI0iTUscjezAYbNz5oWLKUCFquSMWKRpDaDlUAAkq38kKTZtpDqomzwtL0Lay0f1bzHMf_AGYFsdddFp_8y4o3VxKKiDnHzVwBIsTt9OFt8Y9goJ2kR7rY5RBGGZPgAHAATJ");
		//HoagFKDcsGMVCIY2vOjf9sPmh5EQUbQAcIz6VAwYkh61w0XfSjnxLpdi_SC3kbBUvpyO9S9iy3P0uuYMQ2GQdg
		//	System.out.println(jo.getString("ticket"));
		Set set = jo.entrySet();
		Iterator it = set.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		System.out.println(userService.initJs());
	}
	
}
