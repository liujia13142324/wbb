package com.l.wbb.bean;

import java.util.Date;

public class Comment {
	private String openId ;
	private Integer infoId;
	private String commentContent;
	private Date publishDate;
	public Comment(String openId, Integer infoId, String commentContent, Date publishDate) {
		super();
		this.openId = openId;
		this.infoId = infoId;
		this.commentContent = commentContent;
		this.publishDate = publishDate;
	}
	@Override
	public String toString() {
		return "Comment [openId=" + openId + ", infoId=" + infoId + ", commentContent=" + commentContent
				+ ", publishDate=" + publishDate + "]";
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public Integer getInfoId() {
		return infoId;
	}
	public void setInfoId(Integer infoId) {
		this.infoId = infoId;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	public Date getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	
	
}
