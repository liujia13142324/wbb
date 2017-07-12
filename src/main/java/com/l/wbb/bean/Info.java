package com.l.wbb.bean;

import java.util.Date;
import java.util.List;

public class Info {
	private String openId ;
	private Integer themeId;
	private Integer infoId 	 ;
	private String  infoContent ;
	private Date publishTime ;
	private Integer commentCount;
	
	private List<Image> imgs;
	private List<LikeInfo> likeinfo;
	@Override
	public String toString() {
		return "Info [openId=" + openId + ", themeId=" + themeId + ", infoId=" + infoId +  ", infoContent=" + infoContent + ", publishTime=" + publishTime + ", imgs=" + imgs + ", likeinfo="
				+ likeinfo +", commentCount="+commentCount+ "]";
	}

	public Info(String openId, Integer themeId, Integer infoId,  String infoContent, Date publishTime,
			Integer commentCount, List<Image> imgs, List<LikeInfo> likeinfo) {
		super();
		this.openId = openId;
		this.themeId = themeId;
		this.infoId = infoId;
		this.infoContent = infoContent;
		this.publishTime = publishTime;
		this.commentCount = commentCount;
		this.imgs = imgs;
		this.likeinfo = likeinfo;
	}

	public Integer getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(Integer commentCount) {
		this.commentCount = commentCount;
	}

	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
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
	public String getInfoContent() {
		return infoContent;
	}
	public void setInfoContent(String infoContent) {
		this.infoContent = infoContent;
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
