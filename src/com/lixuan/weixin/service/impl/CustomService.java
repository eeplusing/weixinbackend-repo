package com.lixuan.weixin.service.impl;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import com.lixuan.weixin.model.RespBaseMessage;
import com.lixuan.weixin.model.RespMediaMessage;
import com.lixuan.weixin.model.RespMusicMessage;
import com.lixuan.weixin.model.RespNewsMessage;
import com.lixuan.weixin.model.RespTextMessage;
import com.lixuan.weixin.model.RespVideoMessage;
import com.lixuan.weixin.util.ConstantUtil;
import com.lixuan.weixin.util.StringUtil;
import com.lixuan.weixin.util.WeixinUtil;

/**
 * 发送客服消息
 * @author caspar.chen
 * @version 1.0
 * 
 */
public class CustomService {

	public static Logger log = Logger.getLogger(CustomService.class);

	private static String CUSTOME_URL = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=ACCESS_TOKEN";

	public static Map<String, RespBaseMessage> bulidMessageMap = new HashMap<String, RespBaseMessage>();
	
	static 
	{
		//回复文本
		bulidMessageMap.put(ConstantUtil.RESP_MESSAGE_TYPE_TEXT, new RespTextMessage());
		
		//回复新闻消息
		bulidMessageMap.put(ConstantUtil.RESP_MESSAGE_TYPE_NEWS, new RespNewsMessage());
		
		//回复图片
		bulidMessageMap.put(ConstantUtil.RESP_MESSAGE_TYPE_IMAGE, new RespMediaMessage());
		
		//回复语音
		bulidMessageMap.put(ConstantUtil.RESP_MESSAGE_TYPE_VOICE, new RespMediaMessage());
		
		//回复视频
		bulidMessageMap.put(ConstantUtil.RESP_MESSAGE_TYPE_VIDEO, new RespVideoMessage());
		
		//回复音乐
		bulidMessageMap.put(ConstantUtil.RESP_MESSAGE_TYPE_MUSIC, new RespMusicMessage());
	}
	
	/**
	 * 发送客服消息
	 * @param obj消息对象
	 * @return 是否发送成功
	 */
	public static boolean sendCustomerMessage(Object obj) 
	{
		boolean bo = false;
		String url = CUSTOME_URL.replace("ACCESS_TOKEN", WeixinUtil.getToken());
		JSONObject json = JSONObject.fromObject(obj);
		System.out.println(json);
		JSONObject jsonObject = WeixinUtil.httpsRequest(url, "POST", json.toString());
		if (null != jsonObject) 
		{
			if (StringUtil.isNotEmpty(jsonObject.getString("errcode"))
					&& jsonObject.getString("errcode").equals("0")) 
			{
				bo = true;
			}
		}
		return bo;
	}

	
	/**
	 * 构建基本消息
	 * @param toUser        接受者用户openId
	 * @param msgType       消息类型
	 * @return BaseMessage  基本消息对象
	 */
	public static Object bulidCustomerBaseMessage(String toUser, String msgType) 
	{
		RespBaseMessage message = bulidMessageMap.get(msgType);
		message.setToUserName(toUser);
		message.setMsgType(msgType);
		return message;
	}

}
