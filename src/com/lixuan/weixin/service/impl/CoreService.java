 
package com.lixuan.weixin.service.impl;

import java.util.Date;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;
import com.lixuan.weixin.model.message.resp.TextMessage;
import com.lixuan.weixin.util.ConstantUtil;
import com.lixuan.weixin.util.MessageUtil;

/**  
 * @ClassName:CoreService   
 * @Date:     2016年1月21日 下午8:18:27  
 * @author   CAOPENG  
 * @version  1.0 
 * @since    JDK 1.8  
 * @right    Copyright (c) 2016, lixuan.com All Rights Reserved.   
 * @see        
 */

@Service
public class CoreService 
{
	/**
	* 处理微信发来的请求
	* @param request
	* @return
	*/ 
	 public static String processRequest(HttpServletRequest request) 
	 {
		 //返回的消息
		 String respMessage = null; 
		 //事件类型
		 String eventType = null;
		 try 
		 { 
			 // 默认返回的文本消息内容 
			 String respContent = " eplus拼命工作也没有找到主人想要的东西!"; 
		
			 // xml请求解析
			 Map<String, String> requestMap = MessageUtil.parseXml(request);
		
			 // 发送方帐号(open_id)
			 String fromUserName = requestMap.get("FromUserName"); 
		
			 // 公众帐号
			 String toUserName = requestMap.get("ToUserName"); 
		
			 // 消息类型
			 String msgType = requestMap.get("MsgType"); 
		
			 // 回复文本消息
			 TextMessage textMessage = new TextMessage();
			 textMessage.setToUserName(fromUserName); 
		     textMessage.setFromUserName(toUserName); 
		
			 textMessage.setCreateTime(new Date().getTime());
			 textMessage.setMsgType(ConstantUtil.RESP_MESSAGE_TYPE_TEXT);
			 textMessage.setFuncFlag(0); 
		
			 // 文本消息
			 if (msgType.equals(ConstantUtil.REQ_MESSAGE_TYPE_TEXT))
			 {
				 respContent = "欢迎光临Eplus平台！-----From 503 all members";
			 } 
		
			 // 图片消息 
			 else if (msgType.equals(ConstantUtil.REQ_MESSAGE_TYPE_IMAGE)) 
			 {
				 respContent = "您发送的是图片消息!"; 
			 }
		
			 // 地理位置消息 
			 else if (msgType.equals(ConstantUtil.REQ_MESSAGE_TYPE_LOCATION)) 
			 {
				 respContent = "您发送的是地理位置消息!";
			 } 
		
			// 链接消息
			else if (msgType.equals(ConstantUtil.REQ_MESSAGE_TYPE_LINK)) 
			{
				respContent = "您发送的是链接消息!"; 
			} 
		
			 // 音频消息 
			else if (msgType.equals(ConstantUtil.REQ_MESSAGE_TYPE_VOICE)) 
		    {
				respContent = "您发送的是音频消息!";
			} 
		
			 // 事件推送 
			else if (msgType.equals(ConstantUtil.REQ_MESSAGE_TYPE_EVENT)) 
			{
				// 获取事件类型
				eventType = requestMap.get("Event"); 
				 //订阅 
				if (eventType.equals(ConstantUtil.EVENT_TYPE_SUBSCRIBE)) 
				{
					 respContent = "欢迎光临Eplus!   谢谢您的关注!";
				} 
			
				 // 取消订阅 
				else if (eventType.equals(ConstantUtil.EVENT_TYPE_UNSUBSCRIBE)) 
				{
				 // TODO 取消订阅后用户再收不到公众号发送的消息,因此不需要回复消息
				} 
			
				 // 自定义菜单点击事件
			
				else if (eventType.equals(ConstantUtil.EVENT_TYPE_CLICK)) 
				{
				 // TODO 自定义菜单权没有开放,暂不处理该类消息
				}
			}
		
			textMessage.setContent(respContent);
			respMessage = MessageUtil.textMessageToXml(textMessage); 
		} 
		catch (Exception e) 
		{
			e.printStackTrace(); 
		}
	
		return respMessage;
	}
	
}
  
