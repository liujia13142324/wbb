package com.l.wbb.bean;

public class Wechat {
	private long timestamp;
	private String nonceStr;
	private String url;
	private static final String appId = "wxacc65ec5e8282347";
	private static final String secret = "c221ba7b6a3ac1e29db85769d4dd675e";
	private String signature ;
	
	@Override
	public String toString() {
		return "Wechat [timestamp=" + timestamp + ", nonceStr=" + nonceStr + ", url=" + url + ", signature=" + signature
				+ "]";
	}

	public Wechat() {
	}
	
	public Wechat(long timestamp, String nonceStr, String url, String signature) {
		super();
		this.timestamp = timestamp;
		this.nonceStr = nonceStr;
		this.url = url;
		this.signature = signature;
	}
	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	public String getNonceStr() {
		return nonceStr;
	}
	public void setNonceStr(String nonceStr) {
		this.nonceStr = nonceStr;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public static String getAppid() {
		return appId;
	}
	public static String getSecret() {
		return secret;
	}
	
	
}
