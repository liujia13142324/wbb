package com.l.wbb.bean;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class Goods {
	private String openId ;
	private Integer goodsId;
	private String goodsTitle;
	private String goodsIntroduction;
	private Float price;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")  
	private Date publishTime ;
	// 主图
	private GoodsImage mainImage;
	private String tips;
	private String qq;
	private Integer commentCount;

	public Goods() {
		// TODO Auto-generated constructor stub
	}
	
	public Goods(String openId, Integer goodsId, String goodsTitle, String goodsIntroduction, Float price,
			Date publishTime, GoodsImage mainImage, String tips, String qq, Integer commentCount) {
		super();
		this.openId = openId;
		this.goodsId = goodsId;
		this.goodsTitle = goodsTitle;
		this.goodsIntroduction = goodsIntroduction;
		this.price = price;
		this.publishTime = publishTime;
		this.mainImage = mainImage;
		this.tips = tips;
		this.qq = qq;
		this.commentCount = commentCount;
	}

	@Override
	public String toString() {
		return "Goods [openId=" + openId + ", goodsId=" + goodsId + ", goodsTitle=" + goodsTitle
				+ ", goodsIntroduction=" + goodsIntroduction + ", price=" + price + ", publishTime=" + publishTime
				+ ", mainImage=" + mainImage + ", tips=" + tips + ", qq=" + qq + ", commentCount=" + commentCount + "]";
	}

	public Integer getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(Integer commentCount) {
		this.commentCount = commentCount;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getTips() {
		return tips;
	}

	public void setTips(String tips) {
		this.tips = tips;
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


	public String getGoodsTitle() {
		return goodsTitle;
	}

	public void setGoodsTitle(String goodsTitle) {
		this.goodsTitle = goodsTitle;
	}

	public String getGoodsIntroduction() {
		return goodsIntroduction;
	}

	public void setGoodsIntroduction(String goodsIntroduction) {
		this.goodsIntroduction = goodsIntroduction;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Date getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}

	public GoodsImage getMainImage() {
		return mainImage;
	}

	public void setMainImage(GoodsImage mainImage) {
		this.mainImage = mainImage;
	}
	
	
	
	
}
