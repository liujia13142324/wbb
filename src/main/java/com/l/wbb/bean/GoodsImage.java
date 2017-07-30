package com.l.wbb.bean;

/**
 * 对应着数据的 mainImg 和 subImg两个关系模式
 * @author lenovo
 *
 */
public class GoodsImage {

	private Integer imgId;
	private String imgPath;
	
	public GoodsImage() {
	}
	
	public GoodsImage(Integer imgId, String imgPath) {
		super();
		this.imgId = imgId;
		this.imgPath = imgPath;
	}
	@Override
	public String toString() {
		return "Image [imgId=" + imgId + ", imgPath=" + imgPath + "]";
	}
	public Integer getImgId() {
		return imgId;
	}
	public void setImgId(Integer imgId) {
		this.imgId = imgId;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	
}
