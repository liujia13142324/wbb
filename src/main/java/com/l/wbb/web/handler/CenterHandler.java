package com.l.wbb.web.handler;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.l.wbb.bean.User;
import com.l.wbb.service.UserService;

@Controller
@RequestMapping("/center")
public class CenterHandler {
	
	@Autowired
	private UserService userService ;
	
	@RequestMapping("/enter")
	public String getUserInfo(String code,HttpSession session){
	
		try {
			//User user = userService.findUser(code);
			User user = new User("aaaaaa","aaaaaa",1,"img/QQ.png");
			if (user.getOpenid()!=null){
				userService.checkUser(user);
				session.setAttribute("user", user);
				// 跳转到另外一个handler , 需改成重定向
				return "redirect:/info/infoCenter";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "/fail";
	}
	
	@RequestMapping("initJs")
	@ResponseBody
	public Object initWetJs(){
		return userService.initJs();
	}
	
	
}
