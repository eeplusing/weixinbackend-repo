 
package com.lixuan.weixin.model.message.req;  
/**  
 * ClassName:LocationMessage   
 * Date:     2016年1月21日 上午9:49:31  
 * @author   CAOPENG  
 * @version  1.0 
 * @since    JDK 1.7  
 * @right    Copyright (c) 2016, lixuan.com All Rights Reserved.   
 * @see        
 */
public class LocationMessage extends BaseMessage 
{
	/**
	 * 地理位置维度
	 */
	private String LocationX;
	/**
	 * 地理位置经度
	 */
	private String LocationY;

	/**
	 * 地图缩放大小
	 */
	private String Scale;

	/**
	 * 地理位置信息
	 */
	private String Label;


	public String getLocationX() {
		return LocationX;
	}

	public void setLocationX(String locationX) {
		LocationX = locationX;
	}

	public String getLocationY() {
		return LocationY;
	}

	public void setLocationY(String locationY) {
		LocationY = locationY;
	}

	public String getScale() {
		return Scale;
	}

	public void setScale(String scale) {
		Scale = scale;
	}

	public String getLabel() {
		return Label;
	}

	public void setLabel(String label) {
		Label = label;
	}
	
}
  
