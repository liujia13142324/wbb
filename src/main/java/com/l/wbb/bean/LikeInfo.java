package com.l.wbb.bean;

public class LikeInfo {
	private String openId ;
	private Integer infoId;
	@Override
	public String toString() {
		return "LikeInfo [openId=" + openId + ", infoId=" + infoId + "]";
	}
	public LikeInfo(String openId, Integer infoId) {
		super();
		this.openId = openId;
		this.infoId = infoId;
	} 
	public LikeInfo() {
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
	
}
