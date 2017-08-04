package com.l.wbb.mapper;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.l.wbb.bean.Theme;
import com.l.wbb.service.InfoService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring.xml", "classpath:spring-mvc.xml"})//可插拔式
public class InfoMapperTest {

	@Autowired
	private InfoService infoService;
	@Test
	public void testGetAllTheme() {
		List<Theme> themes=infoService.getAllTheme();
		System.out.println(themes);
		assertNotNull(themes);
	}
	
	
	
}
