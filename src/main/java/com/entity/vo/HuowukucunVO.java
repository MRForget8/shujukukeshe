package com.entity.vo;

import com.entity.HuowukucunEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 货物库存
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2022-07-24 19:54:51
 */
public class HuowukucunVO  implements Serializable {
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
	 * 货物来源
	 */
	
	private String huowulaiyuan;
		
	/**
	 * 运输航线
	 */
	
	private String yunshuhangxian;
		
	/**
	 * 货物介绍
	 */
	
	private String huowujieshao;
				
	
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
	 * 设置：货物来源
	 */
	 
	public void setHuowulaiyuan(String huowulaiyuan) {
		this.huowulaiyuan = huowulaiyuan;
	}
	
	/**
	 * 获取：货物来源
	 */
	public String getHuowulaiyuan() {
		return huowulaiyuan;
	}
				
	
	/**
	 * 设置：运输航线
	 */
	 
	public void setYunshuhangxian(String yunshuhangxian) {
		this.yunshuhangxian = yunshuhangxian;
	}
	
	/**
	 * 获取：运输航线
	 */
	public String getYunshuhangxian() {
		return yunshuhangxian;
	}
				
	
	/**
	 * 设置：货物介绍
	 */
	 
	public void setHuowujieshao(String huowujieshao) {
		this.huowujieshao = huowujieshao;
	}
	
	/**
	 * 获取：货物介绍
	 */
	public String getHuowujieshao() {
		return huowujieshao;
	}
			
}
