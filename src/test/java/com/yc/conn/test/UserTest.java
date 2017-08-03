package com.yc.conn.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.l.wbb.bean.User;
import com.l.wbb.service.InfoService;
import com.l.wbb.service.UserService;

//@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class UserTest {
	@Autowired
	private UserService userService;
	
	@Test
	public void TestcheckUser(){
		ApplicationContext cxt=new ClassPathXmlApplicationContext("spring.xml");
		userService=(UserService) cxt.getBean("userService");
		User user =new User();
		user.setOpenid("5fdjfdsjkfka");
		user.setNickname("dfhff");
		user.setSex(1);
		user.setHeadimgurl("img/QQ.png");
		userService.checkUser(user);
	}
}
