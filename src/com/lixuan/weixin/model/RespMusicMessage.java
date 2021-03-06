package com.lixuan.weixin.model;

/**
 * 音乐消息
* Date:     2016年1月21日 上午9:47:22  
 * @author   CAOPENG  
 * @version  1.0 
 * @since    JDK 1.7  
 * @right    Copyright (c) 2016, lixuan.com All Rights Reserved.   
 * @see        
 */
public class RespMusicMessage extends RespBaseMessage {
	/**
	 * 音乐名称
	 */
	private String title;
	
	/**
	 * 音乐描述
	 */
	private String description;
	
	/**
	 * 音乐链接
	 */
	private String musicUrl;
	
	/**
	 * 高质量音乐链接，WIFI环境优先使用该链接播放音乐
	 */
	private String hQMusicUrl;
	
	/**
	 * 缩略图的媒体id，通过上传多媒体文件，得到的id
	 */
	private String thumbMediaId;

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

	public String getMusicUrl() {
		return musicUrl;
	}

	public void setMusicUrl(String musicUrl) {
		this.musicUrl = musicUrl;
	}

	public String gethQMusicUrl() {
		return hQMusicUrl;
	}

	public void sethQMusicUrl(String hQMusicUrl) {
		this.hQMusicUrl = hQMusicUrl;
	}

	public String getThumbMediaId() {
		return thumbMediaId;
	}

	public void setThumbMediaId(String thumbMediaId) {
		this.thumbMediaId = thumbMediaId;
	}

	public RespMusicMessage(String title, String description, String musicUrl,
			String hQMusicUrl, String thumbMediaId) {
		super();
		this.title = title;
		this.description = description;
		this.musicUrl = musicUrl;
		this.hQMusicUrl = hQMusicUrl;
		this.thumbMediaId = thumbMediaId;
	}

	public RespMusicMessage() {
		super();
	}
	
}