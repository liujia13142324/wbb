package com.l.wbb.bean;

import java.util.Date;

public class GoodsComment {
	private String openId ;
	private Integer goodsId;
	private String commentContent;
	private Date publishDate;
	public GoodsComment(String openId, Integer goodsId, String commentContent, Date publishDate) {
		super();
		this.openId = openId;
		this.goodsId = goodsId;
		this.commentContent = commentContent;
		this.publishDate = publishDate;
	}
	@Override
	public String toString() {
		return "Comment [openId=" + openId + ", goodsId=" + goodsId + ", commentContent=" + commentContent
				+ ", publishDate=" + publishDate + "]";
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
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
