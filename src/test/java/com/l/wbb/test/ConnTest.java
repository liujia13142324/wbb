package com.l.wbb.test;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;



//@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring.xml", "classpath:spring-mvc.xml"})
//@ContextConfiguration("classpath:spring.xml")
public class ConnTest {
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	@Test
	public void testConn() {
		ApplicationContext cxt = new ClassPathXmlApplicationContext("spring.xml");
		dataSource = (DataSource) cxt.getBean("dataSource");
		Connection con = null;
		try {
			con = dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException("连接失败！！！", e);
		}
		assertNotNull(con);	
	}
	
	
	@Test
	public void testConn02() {
		Connection con = sqlSessionFactory.openSession().getConnection();
		assertNotNull(con);	
	}
	@Test
	public void URLConnection(){
		try {
			URL url = new URL("http://localhost:6060/");
			URLConnection conn = url.openConnection();
			conn.connect();
			
			conn.getOutputStream();
			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testRequest(){
		
	}
	
}
