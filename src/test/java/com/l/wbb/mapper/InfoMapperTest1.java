package com.l.wbb.mapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;

import com.l.wbb.bean.Image;
import com.l.wbb.bean.Info;
import com.l.wbb.bean.Theme;
import com.l.wbb.bean.User;
import com.l.wbb.service.InfoService;

/*@RunWith(SpringJUnit4ClassRunner.class)
*/@ContextConfiguration(locations={"classpath:spring.xml", "classpath:spring-mvc.xml"})//可插拔式
public class InfoMapperTest1 {
	
	private static InfoService infoService;
	private static InfoMapper infoMapper;
	
	static{
		ApplicationContext cxt = new ClassPathXmlApplicationContext("spring.xml");
		infoService = (InfoService) cxt.getBean("infoService");
		infoMapper = (InfoMapper) cxt.getBean("infoMapper");
	}
	
	
	@Test
	public void testGetAllTheme() {
		List<Theme> themes=infoService.getAllTheme();
		System.out.println(themes);
		for(Theme theme:themes){
			System.out.println(theme);
		}
		assertNotNull(themes);
	}

	@Test
	public void testInsertInfo() {
		User user = new User();
		user.setOpenid("cccccc");
		Info info=new Info(user,1,"今天周六哦");
		int result=infoMapper.insertInfo(info);
		System.out.println(result);
		assertEquals(result,1);
	}

	@Test
	public void testInsertImage() {
		List<Image> images=Arrays.asList(new Image(16,"/upload/22.jpg"),new Image(17,"/upload/33.jpg"),new Image(18,"/upload/44.jpg"));
		int result=infoMapper.insertImage(images);
		System.out.println(result);
	}

	@Test
	public void testGetUserHistory() {
		List<Info> info=new ArrayList<Info>();
		info=infoService.getUserHistory("3");
		System.out.println(info);
	}

	
	@Test
	public void getInfoByTheme() {
		List<Info> info=new ArrayList<Info>();
		info=infoService.getInfoByTheme(4);
		System.out.println(info);
	}

}
