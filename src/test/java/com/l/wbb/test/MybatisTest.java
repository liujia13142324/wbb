package com.l.wbb.test;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.l.wbb.service.TestService;

/*@RunWith(SpringJUnit4ClassRunner.class)*/
@ContextConfiguration("classpath:spring.xml")
public class MybatisTest {

	private TestService testService;
	
	@Test
	public void testSelect(){
		ApplicationContext cxt = new ClassPathXmlApplicationContext("spring.xml");
		testService = (TestService) cxt.getBean("testService");
		System.out.println(testService.testSelect());
	}
	
}
