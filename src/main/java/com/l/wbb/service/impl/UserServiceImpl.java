package com.l.wbb.service.impl;

import java.io.IOException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.l.wbb.bean.User;
import com.l.wbb.bean.Wechat;
import com.l.wbb.context.WBBConst;
import com.l.wbb.context.WbbUtil;
import com.l.wbb.mapper.UserMapper;
import com.l.wbb.service.UserService;
import com.l.wbb.util.Encrypt;

import net.sf.json.JSONObject;

@Service("userService")
public class UserServiceImpl implements UserService{

	
	
	
	@Autowired
	private UserMapper userMapper;
	
	/*
	 * 调用接口获得用户的基本信息
	 * @see com.l.wbb.service.UserService#findUser(java.lang.String)
	 */
	public User findUser(String code) {
		String accesstokenRequest = "https://api.weixin.qq.com/sns/oauth2/access_token?appid="+WbbUtil.APPID
				+"&secret="+WbbUtil.APPSECRET+"&code="+code+"&grant_type=authorization_code";

		// TODO 发送 http 请求 ，获得 access_token ，正确的返回格式为
		/*{ "access_token":"ACCESS_TOKEN",    
			 "expires_in":7200,    
			 "refresh_token":"REFRESH_TOKEN",    
			 "openid":"OPENID",    
			 "scope":"SCOPE" } 
		*/
		JSONObject jsonObject=null;
		try {
			jsonObject = WbbUtil.doGetJson(accesstokenRequest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		String openid=jsonObject.getString("openid");
		String accesstoken=jsonObject.getString("access_token");
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
		JSONObject userInfo=null;
		try {
			userInfo = WbbUtil.doGetJson(userinfoRequest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(userInfo);
		User user = new User();
		//TODO 设置 openid，nickname，sex，headimgurl
		user=(User) JSONObject.toBean(userInfo,User.class);
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
			if(!olderUser.equals(user)){
				userMapper.updateUser(user);
			}
		}
	}
	
	@Override
	public Wechat initJs() {
		Wechat we = new Wechat();
		we.setNonceStr("balabalabalabiubiubiu");
		we.setTimestamp(new Date().getTime());
		we.setUrl("http://www."+WBBConst.DOMAIN+"/wbb/page/test.jsp");
		//String access_token = getAccessToken().getString("access_token");
		String access_token = "_ygShsSPX3zCNPPDOPb_akQi-Vj0GX0HsHQA5hb6hH8KzXi_6HcnJmYOG5nA3IanvLT4Ab-HQkCc98Wr5-kF24kFwUnGSi5f6vxa6-fgS9pnY_UQ-bpDu7QMFJbOH9xhARAiAHAGXG";
		String jsapi_ticket = getJsApiTicket(access_token).getString("ticket");
		String string = jsapi_ticket+"&noncestr="+we.getNonceStr()
						+"&timestamp="+we.getTimestamp()+"&url="+we.getUrl();
		we.setSignature(Encrypt.sha1(string));
		return we;
	}

	private String access_token_url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+Wechat.getAppid()+"&secret="+Wechat.getSecret();
	
	public JSONObject getAccessToken() {
		JSONObject jsonObject=null;
		try {
			jsonObject = WbbUtil.doGetJson(access_token_url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonObject;
	}
	
	public JSONObject getJsApiTicket(String access_token) {
		String 	jsapi_ticketUrl ="https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token="+access_token+"&type=jsapi";
		JSONObject jsonObject=null;
		try {
			jsonObject = WbbUtil.doGetJson(jsapi_ticketUrl);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonObject;
	}
}
