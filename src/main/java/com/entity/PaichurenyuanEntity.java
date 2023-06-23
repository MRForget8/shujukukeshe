package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 派出人员
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2022-07-24 19:54:51
 */
@TableName("paichurenyuan")
public class PaichurenyuanEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public PaichurenyuanEntity() {
		
	}
	
	public PaichurenyuanEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 工号
	 */
					
	private String gonghao;
	
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
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
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
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
