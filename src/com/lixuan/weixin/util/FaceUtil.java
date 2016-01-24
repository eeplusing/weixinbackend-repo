package com.lixuan.weixin.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import com.lixuan.weixin.faceapp.http.HttpRequests;
import com.lixuan.weixin.faceapp.http.PostParameters;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


/**
 * 图片分析工具
 */
public class FaceUtil 
{
	public static String faceMessage(String path)
	{
		//请求类
		HttpRequests hsr = new HttpRequests("fdsfsdf", "fsdfsf");
		
		//请求传入的参数
		PostParameters pps = new PostParameters(); 
		
		//保存传进来的图片
		pps.setImg(new File(path));
		
		//识别
		JSONObject json = hsr.detectionDetect(pps);
		
		JSONArray array = json.getJSONArray("face");
		
		StringBuffer result = new StringBuffer();
		for(int i = 0; i < array.size(); i++)
		{
			JSONObject jo = array.getJSONObject(i);
			JSONObject attrJson = jo.getJSONObject("attribute");
			
			JSONObject jsonAge = attrJson.getJSONObject("age");
			
			int range = jsonAge.getInt("range");
			int value = jsonAge.getInt("value");
			result.append("年龄：" + value + "岁(误差范围：" + range + "岁);\n");
			
			String genderStr = attrJson.getJSONObject("gender").getString("value");
			Double confidence = attrJson.getJSONObject("gender").getDouble("confidence");
			result.append("性别：" + genderStr + "(正确率：" + confidence + "%);\n");
			
			String raceStr = attrJson.getJSONObject("race").getString("value");
			Double raceConfidence = attrJson.getJSONObject("race").getDouble("confidence");
			result.append("种族：" + raceStr + "(正确率：" + raceConfidence + "%);\n");
			
			Double smiling = attrJson.getJSONObject("smiling").getDouble("value");
			result.append("正在笑(正确率：" + smiling + "%);\n");
			
		}
		return result.toString();
	}
	
	//
	/**
	 * 将网络文件保存到本地
	* @param destUrl：目标文件地址
	* @param filePath：要保存到的地址，该路径是文件的全路径，包括文件名及其扩展名
	 */
	public static void saveToFile(String destUrl, String filePath)
	{
		FileOutputStream fos = null;
		BufferedInputStream bis = null;
		HttpURLConnection httpUrl = null;
		
		URL url = null;
		int BUFFER_SIZE = 1024;
		byte[] buf = new byte[BUFFER_SIZE];
		int size = 0;
		try 
		{
			url = new URL(destUrl);
			httpUrl = (HttpURLConnection) url.openConnection();
			httpUrl.connect();
			
			bis = new BufferedInputStream(httpUrl.getInputStream());
			fos = new FileOutputStream(filePath);
			
			while((size = bis.read(buf)) != -1)
			{
				fos.write(buf, 0, size);
			}
			fos.flush();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				fos.close();
				bis.close();
				httpUrl.disconnect();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	
	
	public static void main(String[] args)
	{
		saveToFile("http://cdn.duitang.com/uploads/item/201501/13/20150113172039_Ea5ry.jpeg", "d:/image/pic1.jpeg");
	}
	

}
