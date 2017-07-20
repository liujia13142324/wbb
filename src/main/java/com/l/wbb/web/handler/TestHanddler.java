package com.l.wbb.web.handler;

import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class TestHanddler {
	
	@RequestMapping("/test")
	public void test1(String a){
		
		System.out.println("comming ~");
		System.out.println(a);
	}
	
	@RequestMapping("/car")
	@ResponseBody
	public Object carInfo() throws MalformedURLException{
		//Access-Control-Allow-Origin
		URL url = new URL("http://www.autohome.com.cn/ashx/AjaxIndexCarFind.ashx?type=1");
		
		
		return null;
	}
}
