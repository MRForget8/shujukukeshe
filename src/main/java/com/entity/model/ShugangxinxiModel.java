package com.entity.model;

import com.entity.ShugangxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 疏港信息
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2022-07-24 19:54:51
 */
public class ShugangxinxiModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 规格
	 */
	
	private String guige;
		
	/**
	 * 数量
	 */
	
	private Integer shuliang;
		
	/**
	 * 运输方式
	 */
	
	private String yunshufangshi;
		
	/**
	 * 堆放地点
	 */
	
	private String duifangdidian;
		
	/**
	 * 疏港时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date shugangshijian;
		
	/**
	 * 备注
	 */
	
	private String beizhu;
		
	/**
	 * 工号
	 */
	
	private String gonghao;
		
	/**
	 * 姓名
	 */
	
	private String xingming;
				
	
	/**
	 * 设置：规格
	 */
	 
	public void setGuige(String guige) {
		this.guige = guige;
	}
	
	/**
	 * 获取：规格
	 */
	public String getGuige() {
		return guige;
	}
				
	
	/**
	 * 设置：数量
	 */
	 
	public void setShuliang(Integer shuliang) {
		this.shuliang = shuliang;
	}
	
	/**
	 * 获取：数量
	 */
	public Integer getShuliang() {
		return shuliang;
	}
				
	
	/**
	 * 设置：运输方式
	 */
	 
	public void setYunshufangshi(String yunshufangshi) {
		this.yunshufangshi = yunshufangshi;
	}
	
	/**
	 * 获取：运输方式
	 */
	public String getYunshufangshi() {
		return yunshufangshi;
	}
				
	
	/**
	 * 设置：堆放地点
	 */
	 
	public void setDuifangdidian(String duifangdidian) {
		this.duifangdidian = duifangdidian;
	}
	
	/**
	 * 获取：堆放地点
	 */
	public String getDuifangdidian() {
		return duifangdidian;
	}
				
	
	/**
	 * 设置：疏港时间
	 */
	 
	public void setShugangshijian(Date shugangshijian) {
		this.shugangshijian = shugangshijian;
	}
	
	/**
	 * 获取：疏港时间
	 */
	public Date getShugangshijian() {
		return shugangshijian;
	}
				
	
	/**
	 * 设置：备注
	 */
	 
	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}
	
	/**
	 * 获取：备注
	 */
	public String getBeizhu() {
		return beizhu;
	}
				
	
	/**
	 * 设置：工号
	 */
	 
	public void setGonghao(String gonghao) {
		this.gonghao = gonghao;
	}
	
	/**
	 * 获取：工号
	 */
	public String getGonghao() {
		return gonghao;
	}
				
	
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
			
}
