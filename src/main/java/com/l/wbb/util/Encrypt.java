package com.l.wbb.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 加密工具类
 * md5加密出来的长度是32位
 * sha加密出来的长度是40位
 */
public class Encrypt {
	/**
	 * 测试
	 */
	public static void main(String[] args) {
		/*// md5加密测试
		String md5_1 = md5("a");
		String md5_2 = md5("1");
		
		//System.out.println(md5_1 + "\n" + md5_2);
		// sha加密测试
		String sha_1 = sha("123456");
		String sha_2 = sha("abc");*/
		//System.out.println(sha_1 + "\n" + sha_2);

		//6f9b0a55df8ac28564cb9f63a10be8af6ab3f7c2
		String encrypt = Encrypt.md5AndSha("a");
		
		System.out.println(encrypt.length()+"  "+encrypt);//6f9b0a55df8ac28564cb9f63a10be8af6ab3f7c2
		//System.out.println(Encrypt.md5("a"));//0cc175b9c0f1b6a831c399e269772661
		//System.out.println(Encrypt.sha("a"));  //86f7e437faa5a7fce15d1ddcb9eaeaea377667b8
		//这种是进行一次 md5加密在进行一次sha加密
		//System.out.println(Encrypt.sha(Encrypt.md5("a")));
	}

	/**
	 * 加密
	 * 
	 * @param inputText
	 * @return
	 */
	public static String e(String inputText) {
		return md5(inputText);
	}

	/**
	 * 二次加密，应该破解不了了吧？
	 * @param inputText
	 * @return
	 */
	public static String md5AndSha(String inputText) {
		return sha1(md5(inputText));
	}

	/**
	 * md5加密
	 * @param inputText
	 * @return
	 */
	public static String md5(String inputText) {
		return encrypt(inputText, "md5");
	}

	/**
	 * sha加密
	 * @param inputText
	 * @return
	 */
	public static String sha1(String inputText) {
		return encrypt(inputText, "sha-1");
	}

	/**
	 * md5或者sha-1加密
	 * 
	 * @param inputText
	 *            要加密的内容
	 * @param algorithmName
	 *            加密算法名称：md5或者sha-1，不区分大小写
	 * @return
	 */
	private static String encrypt(String inputText, String algorithmName) {
		if (inputText == null || "".equals(inputText.trim())) {
			throw new IllegalArgumentException("请输入要加密的内容");
		}
		if (algorithmName == null || "".equals(algorithmName.trim())) {
			algorithmName = "md5";
		}
		String encryptText = null;
		try {
			MessageDigest m = MessageDigest.getInstance(algorithmName);
			m.update(inputText.getBytes("UTF-8"));
			byte s[] = m.digest();
			// m.digest(inputText.getBytes("UTF8"));
			return hex(s);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return encryptText;
	}

	/**
	 * 返回十六进制字符串
	 * @param arr
	 * @return
	 */
	private static String hex(byte[] arr) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < arr.length; ++i) {
			sb.append(Integer.toHexString((arr[i] & 0xFF) | 0x100).substring(1, 3));
		}
		return sb.toString();
	}
	
	

}
