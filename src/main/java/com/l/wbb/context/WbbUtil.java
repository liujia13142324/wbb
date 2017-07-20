package com.l.wbb.context;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import net.sf.json.JSONObject;


public class WbbUtil {
		public static final String APPID="wxdd4ef504b3fae2dc";
		public static final String APPSECRET="xiongtingfang433127199307177214x";
		public static JSONObject doGetJson(String url) throws ClientProtocolException, IOException{
			JSONObject jsonObject=null;
			DefaultHttpClient client=new DefaultHttpClient();
			HttpGet httpGet=new HttpGet(url);
			HttpResponse response=client.execute(httpGet);
			HttpEntity entity=response.getEntity();
			if(entity!=null){
				String result=EntityUtils.toString(entity, "UTF-8");
				jsonObject=JSONObject.fromObject(result);
			}
			httpGet.releaseConnection();//释放链接
			return jsonObject;
		}
}
