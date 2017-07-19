package com.l.wbb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.l.wbb.bean.User;
import com.l.wbb.mapper.UserMapper;
import com.l.wbb.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	
	/*
	 * 调用接口获得用户的基本信息
	 * @see com.l.wbb.service.UserService#findUser(java.lang.String)
	 */
	public User findUser(String code) {
		String appid = "";
		String secret = "";
		String accesstokenRequest = "https://api.weixin.qq.com/sns/oauth2/access_token?appid="+appid
				+"&secret="+secret+"&code="+code+"&grant_type=authorization_code";

		// TODO 发送 http 请求 ，获得 access_token ，正确的返回格式为
		/*{ "access_token":"ACCESS_TOKEN",    
			 "expires_in":7200,    
			 "refresh_token":"REFRESH_TOKEN",    
			 "openid":"OPENID",    
			 "scope":"SCOPE" } 
		*/
		
		String openid="";
		String accesstoken="";
		String userinfoRequest = "https://api.weixin.qq.com/sns/userinfo?"
				+"access_token="+accesstoken+"&openid="+openid+"&lang=zh_CN ";
		
		// TODO 发送 http 请求 ，获得userInfo , 正确的返回格式为
		/*{     "openid":" OPENID",  
				 " nickname": NICKNAME,   
				 "sex":"1",   
				 "province":"PROVINCE"   
				 "city":"CITY",   
				 "country":"COUNTRY",    
				 "headimgurl": "http://wx.qlogo.cn/mmopen/g3MonUZtNHkdmzicIlibx6iaFqAc56vxLSUfpb6n5WKSYVY0ChQKkiaJSgQ1dZuTOgvLLrhJbERQQ
				  4eMsv84eavHiaiceqxibJxCfHe/46",  
				 "privilege":[ "PRIVILEGE1" "PRIVILEGE2"],    
				 "unionid": "o6_bmasdasdsad6_2sgVt7hMZOPfL" 
			} 
	*/
		
		User user = new User();
		//TODO 设置 openid，nickname，sex，headimgurl
		
		return user;
	}

	/*
	 * 检查用户信息
	 * 1.如果用户不存在，则插入数据库
	 * 2.如果用户存在，把数据库的user查出来，进行对比，如果不同，则更新数据库
	 * @see com.l.wbb.service.UserService#checkUser(com.l.wbb.bean.User)
	 */
	@Transactional //事务操作，异常不需捕获
	public void checkUser(User user) {
		
		// 查找数据库，是否存在该用户
		User olderUser = userMapper.selectUser(user.getOpenid());
		
		if(olderUser == null){
			//插入数据库
			userMapper.insertUser(user);
		}else{
			//检查两个user是否不一样，若不一样的话更新user userMapper.updateUser(user);
			if(olderUser!=user){
				userMapper.updateUser(user);
			}
		}
	}
}
