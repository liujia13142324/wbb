package com.l.wbb.bean;

import java.util.Date;
import java.util.List;

public class Goods {
	private String openId ;
	private Integer goodsId;
	private String goodsTitle;
	private String goodsIntroduction;
	private Float price;
	private Date publishTime ;
	// 主图
	private GoodsImage mainImage;
	private String tips;
	
	public Goods() {
	}

	@Override
	public String toString() {
		return "Goods [openId=" + openId + ", goodsId=" + goodsId + ", goodsTitle=" + goodsTitle
				+ ", goodsIntroduction=" + goodsIntroduction + ", price=" + price + ", publishTime=" + publishTime
				+ ", mainImage=" + mainImage + ", tips=" + tips + "]";
	}

	public Goods(String openId, Integer goodsId, String goodsTitle, String goodsIntroduction, Float price,
			Date publishTime, GoodsImage mainImage, String tips) {
		super();
		this.openId = openId;
		this.goodsId = goodsId;
		this.goodsTitle = goodsTitle;
		this.goodsIntroduction = goodsIntroduction;
		this.price = price;
		this.publishTime = publishTime;
		this.mainImage = mainImage;
		this.tips = tips;
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
