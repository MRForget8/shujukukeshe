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
 * 货物库存
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2022-07-24 19:54:51
 */
@TableName("huowukucun")
public class HuowukucunEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public HuowukucunEntity() {
		
	}
	
	public HuowukucunEntity(T t) {
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
	 * 货物名称
	 */
					
	private String huowumingcheng;
	
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
	 * 设置：货物名称
	 */
	public void setHuowumingcheng(String huowumingcheng) {
		this.huowumingcheng = huowumingcheng;
	}
	/**
	 * 获取：货物名称
	 */
	public String getHuowumingcheng() {
		return huowumingcheng;
	}
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
