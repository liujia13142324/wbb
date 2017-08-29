package com.l.wbb.web.handler;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import sun.misc.BASE64Decoder;

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

	@RequestMapping("/file")
	@ResponseBody
	public String testUploadFile(@RequestParam("file")CommonsMultipartFile file) throws IllegalStateException, IOException {
		
		long startTime = System.currentTimeMillis();
		System.out.println("fileName：" + file.getOriginalFilename());
		String path = "D:/" + new Date().getTime() + file.getOriginalFilename();

		File newFile = new File(path);
		// 通过CommonsMultipartFile的方法直接写文件（注意这个时候）
		file.transferTo(newFile);
		long endTime = System.currentTimeMillis();
		System.out.println("方法二的运行时间：" + String.valueOf(endTime - startTime) + "ms");
		return "success";

	}
	
	@RequestMapping("/file2")
	@ResponseBody
	public String testUploadFile2(String file) throws IllegalStateException, IOException {
		BASE64Decoder decoder = new BASE64Decoder();
		byte[] b = decoder.decodeBuffer(file);//转码得到图片数据

		ByteArrayInputStream bais = new ByteArrayInputStream(b);
		BufferedImage bi1 = ImageIO.read(bais);

		File w2 = new File("D://test.png");

		ImageIO.write(bi1, "png", w2);

		return "success";
	}
	
}
