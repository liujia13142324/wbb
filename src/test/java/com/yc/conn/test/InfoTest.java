package com.yc.conn.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;

import com.l.wbb.bean.Comment;
import com.l.wbb.bean.Info;
import com.l.wbb.bean.LikeInfo;
import com.l.wbb.service.InfoService;

//@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class InfoTest {
	@Autowired
	private InfoService infoService;
	@Test
	public void getInfobyRange(){
		ApplicationContext cxt=new ClassPathXmlApplicationContext("spring.xml");
		infoService=(InfoService) cxt.getBean("infoService");
		List<Info> infos = infoService.getInfoByRange(0, 10);
		System.out.println(infos);
	}
	
	@Test
	public void TestInfo(){
		ApplicationContext cxt=new ClassPathXmlApplicationContext("spring.xml");
		infoService=(InfoService) cxt.getBean("infoService");
		Comment comment=new Comment("fbjdbfjsbfjsad", 111, "sjdjsnd", new Date(111111111));
		System.out.println(infoService.publishComent(comment));
	}
	
	@Test
	public void TestLike(){
		ApplicationContext cxt=new ClassPathXmlApplicationContext("spring.xml");
		infoService=(InfoService) cxt.getBean("infoService");
		LikeInfo likeInfo=new LikeInfo("fbjdbfjsbfjsad", 111);
		System.out.println(infoService.setLikeInfo(likeInfo,0));
	}
	
	@Test  
	public void TestgetCommentByRange(){
		ApplicationContext cxt=new ClassPathXmlApplicationContext("spring.xml");
		infoService=(InfoService) cxt.getBean("infoService");
		List<Comment> comments=infoService.getCommentByRange(111, 1, 10);
		 Date date=new Date();
		for (Comment comment : comments) {
			
			System.out.println(comment);
		}
	}
	
}
