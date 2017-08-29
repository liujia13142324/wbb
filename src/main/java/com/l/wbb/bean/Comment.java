package com.l.wbb.bean;

import java.util.Date;


public class Comment {
	private User user ;
	
	
	private Integer infoId;
	private String commentContent;
	private Date publishDate;
	
	public Comment(User user, Integer infoId, String commentContent, Date publishDate) {
		super();
		this.user = user;
		this.infoId = infoId;
		this.commentContent = commentContent;
		this.publishDate = publishDate;
	}

	public Comment() {
	}
	
	@Override
	public String toString() {
		return "Comment [user=" + user + ", infoId=" + infoId + ", commentContent=" + commentContent + ", publishDate="
				+ publishDate + "]";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
