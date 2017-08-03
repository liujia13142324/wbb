package com.yc.conn.test;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;

import com.l.wbb.bean.Comment;
import com.l.wbb.bean.GoodsComment;
import com.l.wbb.service.GoodsService;

@ContextConfiguration("classpath:spring.xml")
public class GoodsTest {
	 
	@Autowired
	private GoodsService goodsService;
	
	@Test
	public void getCategoryTest(){
		ApplicationContext cxt=new ClassPathXmlApplicationContext("spring.xml");
		goodsService=(GoodsService) cxt.getBean("goodsService");
		System.out.println(goodsService.getCategory());
	}
	
	@Test
	public void getGoodsByRangeTest(){
		ApplicationContext cxt=new ClassPathXmlApplicationContext("spring.xml");
		goodsService=(GoodsService) cxt.getBean("goodsService");
		System.out.println(goodsService.getGoodsByRange(0, 10));
	}
	@Test
	public void getCommentByRangeTest(){
		ApplicationContext cxt=new ClassPathXmlApplicationContext("spring.xml");
		goodsService=(GoodsService) cxt.getBean("goodsService");
		System.out.println(goodsService.getCommentByRange(11112, 0, 10));
	}
	@Test
	public void getCategoryGoodsByRangeTest(){
		ApplicationContext cxt=new ClassPathXmlApplicationContext("spring.xml");
		goodsService=(GoodsService) cxt.getBean("goodsService");
		System.out.println(goodsService.getCategoryGoodsByRange(1111, 0, 10));
	}
	@Test
	public void getGoodsBySearchTest(){
		ApplicationContext cxt=new ClassPathXmlApplicationContext("spring.xml");
		goodsService=(GoodsService) cxt.getBean("goodsService");
		System.out.println(goodsService.getGoodsBySearch("%ss%"));
	}
	@Test
	public void getUserHistoryTest(){
		ApplicationContext cxt=new ClassPathXmlApplicationContext("spring.xml");
		goodsService=(GoodsService) cxt.getBean("goodsService");
		System.out.println(goodsService.getUserHistory("fbjdbfjsbfjsad"));
	}
	@Test
	public void getSubImageTest(){
		ApplicationContext cxt=new ClassPathXmlApplicationContext("spring.xml");
		goodsService=(GoodsService) cxt.getBean("goodsService");
		System.out.println(goodsService.getSubImage(001));
	}
	@Test
	public void publishComentTest(){
		ApplicationContext cxt=new ClassPathXmlApplicationContext("spring.xml");
		goodsService=(GoodsService) cxt.getBean("goodsService");
		GoodsComment comment=new GoodsComment("fbjdbfjsbfjsad", 11112, "xxxxxx", new Date(1000));
		System.out.println(goodsService.publishComent(comment));
	}
}
