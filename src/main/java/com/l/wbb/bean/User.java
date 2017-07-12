package com.l.wbb.bean;

public class User {
	private String openid ;
	private String nickname ;
	private Integer sex  ;
	private String headimgurl ;
	@Override
	public String toString() {
		return "User [openid=" + openid + ", nickname=" + nickname + ", sex=" + sex + ", headimgurl=" + headimgurl
				+ "]";
	}
	public User(String openid, String nickname, Integer sex, String headimgurl) {
		super();
		this.openid = openid;
		this.nickname = nickname;
		this.sex = sex;
		this.headimgurl = headimgurl;
	}
	
	public User() {
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getHeadimgurl() {
		return headimgurl;
	}
	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}
	
	
}
