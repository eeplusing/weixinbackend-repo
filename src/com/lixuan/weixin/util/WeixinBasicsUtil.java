package com.lixuan.weixin.util;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WeixinBasicsUtil {

	/**
	 *接入微信
	 * @param request
	 * @param response
	 */
	public static void access(HttpServletRequest request, HttpServletResponse response) 
	{
		// 自定义token
		final String TOKEN = "eplus";
		// 微信加密签名
		String signature = request.getParameter("signature");
		// 随机字符串
		String echostr = request.getParameter("echostr");
		// 随机字符串
		String timestamp = request.getParameter("timestamp");
		// 随机数
		String nonce = request.getParameter("nonce");
		
		String[] str = { TOKEN, timestamp, nonce};
		
		// 字典排序
		Arrays.sort(str); 
		String bigStr = str[0] + str[1] + str[2];
		
		// SHA1加密
		String digest = new SHA1().getDigestOfString(bigStr.getBytes()).toLowerCase();
		
		// 确认请求来至微信
		if (digest.equals(signature)) 
		{
			try 
			{
				response.getWriter().print(echostr);
				System.out.println("=============接入微信成功OKOKOK=======================");
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
		
	}
	
	
}
