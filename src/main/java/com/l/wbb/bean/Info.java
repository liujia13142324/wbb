package com.l.wbb.bean;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Info {
	private Integer themeId;
	private Integer infoId 	 ;
	private String infoContent;
	//前端到后台，日期格式转换
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")  
	private Date publishTime ;
	private Integer commentCount;
	
	private User user;
	private List<Image> imgs;
	private List<LikeInfo> likeinfo;

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Info() {
	}
	public Info(Integer themeId, Integer infoId, String infoContent, Date publishTime,
			Integer commentCount, User user, List<Image> imgs, List<LikeInfo> likeinfo) {
		super();
		this.themeId = themeId;
		this.infoId = infoId;
		this.infoContent = infoContent;
		this.publishTime = publishTime;
		this.commentCount = commentCount;
		this.user = user;
		this.imgs = imgs;
		this.likeinfo = likeinfo;
	}

	@Override
	public String toString() {
		return "Info [themeId=" + themeId + ", infoId=" + infoId + ", infoContent=" + infoContent
				+ ", publishTime=" + publishTime + ", commentCount=" + commentCount + ", user=" + user + ", imgs="
				+ imgs + ", likeinfo=" + likeinfo + "]";
	}

	public Info(User user, Integer themeId, String infoContent) {
		super();
		this.user = user;
		this.themeId = themeId;
		this.infoContent = infoContent;
	}




	public Integer getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(Integer commentCount) {
		this.commentCount = commentCount;
	}
	public String getInfoContent() {
		return infoContent;
	}

	public void setInfoContent(String infoContent) {
		this.infoContent = infoContent;
	}

	public Integer getThemeId() {
		return themeId;
	}
	public void setThemeId(Integer themeId) {
		this.themeId = themeId;
	}
	public Integer getInfoId() {
		return infoId;
	}
	public void setInfoId(Integer infoId) {
		this.infoId = infoId;
	}
	public Date getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}
	public List<Image> getImgs() {
		return imgs;
	}
	public void setImgs(List<Image> imgs) {
		this.imgs = imgs;
	}
	public List<LikeInfo> getLikeinfo() {
		return likeinfo;
	}
	public void setLikeinfo(List<LikeInfo> likeinfo) {
		this.likeinfo = likeinfo;
	}
	
}
