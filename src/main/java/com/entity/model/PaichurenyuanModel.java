package com.entity.model;

import com.entity.PaichurenyuanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 派出人员
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2022-07-24 19:54:51
 */
public class PaichurenyuanModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 姓名
	 */
	
	private String xingming;
		
	/**
	 * 职务
	 */
	
	private String zhiwu;
		
	/**
	 * 派出时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date paichushijian;
		
	/**
	 * 派出地点
	 */
	
	private String paichudidian;
		
	/**
	 * 派出事由
	 */
	
	private String paichushiyou;
				
	
	/**
	 * 设置：姓名
	 */
	 
	public void setXingming(String xingming) {
		this.xingming = xingming;
	}
	
	/**
	 * 获取：姓名
	 */
	public String getXingming() {
		return xingming;
	}
				
	
	/**
	 * 设置：职务
	 */
	 
	public void setZhiwu(String zhiwu) {
		this.zhiwu = zhiwu;
	}
	
	/**
	 * 获取：职务
	 */
	public String getZhiwu() {
		return zhiwu;
	}
				
	
	/**
	 * 设置：派出时间
	 */
	 
	public void setPaichushijian(Date paichushijian) {
		this.paichushijian = paichushijian;
	}
	
	/**
	 * 获取：派出时间
	 */
	public Date getPaichushijian() {
		return paichushijian;
	}
				
	
	/**
	 * 设置：派出地点
	 */
	 
	public void setPaichudidian(String paichudidian) {
		this.paichudidian = paichudidian;
	}
	
	/**
	 * 获取：派出地点
	 */
	public String getPaichudidian() {
		return paichudidian;
	}
				
	
	/**
	 * 设置：派出事由
	 */
	 
	public void setPaichushiyou(String paichushiyou) {
		this.paichushiyou = paichushiyou;
	}
	
	/**
	 * 获取：派出事由
	 */
	public String getPaichushiyou() {
		return paichushiyou;
	}
			
}
