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
import com.l.wbb.bean.User;
import com.l.wbb.mapper.InfoMapper;
import com.l.wbb.service.InfoService;

//@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class InfoTest {
	@Autowired
	private InfoService infoService;
	@Autowired
	private InfoMapper infoMapper;
	@Test
	public void getInfobyRange(){
		ApplicationContext cxt=new ClassPathXmlApplicationContext("spring.xml");
		infoService=(InfoService) cxt.getBean("infoService");
		infoMapper = (InfoMapper) cxt.getBean("infoMapper");
		System.out.println(infoMapper.getInfoByRange(0,10));
	}
	
	@Test
	public void TestInfo(){
		ApplicationContext cxt=new ClassPathXmlApplicationContext("spring.xml");
		infoService=(InfoService) cxt.getBean("infoService");
		User user = new User();
		user.setOpenid("aaaaaa");
		Comment comment=new Comment(user, 1, "sjdjsnd", new Date());
		System.out.println(comment);
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
		List<Comment> comments=infoService.getCommentByRange(1, 1, 10);
		for (Comment comment : comments) {
			System.out.println(comment);
		}
	}
	
}
