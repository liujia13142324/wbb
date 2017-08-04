package com.l.wbb.bean;

public class Image {

	private Integer infoId;
	private String imgPath;
	
	public Image() {
	}
	
	public Image(String imgPath) {
		super();
		this.imgPath = imgPath;
	}

	public Image(Integer infoId, String imgPath) {
		super();
		this.infoId = infoId;
		this.imgPath = imgPath;
	}
	@Override
	public String toString() {
		return "Image [infoId=" + infoId + ", imgPath=" + imgPath + "]";
	}
	public Integer getInfoId() {
		return infoId;
	}
	public void setInfoId(Integer infoId) {
		this.infoId = infoId;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	
}
