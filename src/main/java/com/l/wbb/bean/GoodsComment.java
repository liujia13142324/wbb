package com.l.wbb.bean;

import java.util.Date;

public class GoodsComment {
	private User user ;
	
	private Integer goodsId;
	private String commentContent;
	private Date publishDate;
	public GoodsComment(User user, Integer goodsId, String commentContent, Date publishDate) {
		super();
		this.user = user;
		this.goodsId = goodsId;
		this.commentContent = commentContent;
		this.publishDate = publishDate;
	}
	public GoodsComment() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Comment [user=" + user + ", goodsId=" + goodsId + ", commentContent=" + commentContent
				+ ", publishDate=" + publishDate + "]";
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Integer getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
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
