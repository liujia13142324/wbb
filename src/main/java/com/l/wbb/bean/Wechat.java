package com.l.wbb.bean;

public class Wechat {
	private long timestamp;
	private String nonceStr;
	private String url;
	private static final String appId = "wxacc65ec5e8282347";
	private static final String secret = "c221ba7b6a3ac1e29db85769d4dd675e";
	private String access_token;
	private String api_ticket ;
	private String signature ;
	private String string ;
	
	
	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}

	@Override
	public String toString() {
		return "Wechat [timestamp=" + timestamp + ", nonceStr=" + nonceStr + ", url=" + url + ", access_token="
				+ access_token + ", api_ticket=" + api_ticket + ", signature=" + signature + "]";
	}

	public Wechat() {
	}
	
	public Wechat(long timestamp, String nonceStr, String url, String access_token, String api_ticket,
			String signature) {
		super();
		this.timestamp = timestamp;
		this.nonceStr = nonceStr;
		this.url = url;
		this.access_token = access_token;
		this.api_ticket = api_ticket;
		this.signature = signature;
	}
	public String getApi_ticket() {
		return api_ticket;
	}
	public void setApi_ticket(String api_ticket) {
		this.api_ticket = api_ticket;
	}
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
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
