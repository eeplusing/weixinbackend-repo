 
package com.lixuan.weixin.model;  
/**  
 * ClassName:ImageMessage   
 * Date:     2016年1月21日 上午9:47:22  
 * @author   CAOPENG  
 * @version  1.0 
 * @since    JDK 1.7  
 * @right    Copyright (c) 2016, lixuan.com All Rights Reserved.   
 * @see        
 */
public class ReqImageMessage extends ReqBaseMessage 
{
	private String picUrl;

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
}
  
