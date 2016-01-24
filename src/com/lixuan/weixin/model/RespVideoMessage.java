package com.lixuan.weixin.model;

/**
 * 视频消息
 * @author caspar.chen
 * @version 1.0
 * 
 */
public class RespVideoMessage extends RespMediaMessage{
	/**
	 * 视频消息的标题
	 */
	private String title;
	
	/**
	 * 视频消息的描述
	 */
	private String description;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public RespVideoMessage(String title, String description) {
		super();
		this.title = title;
		this.description = description;
	}

	public RespVideoMessage() {
		super();
	}
	
	
}
