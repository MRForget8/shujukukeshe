package com.entity;


import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;


@Data
@TableName("forwarding_info")
public class ForwardingInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 货代公司
	 */
	private String 
forwardingCompany;
	/**
	 * 公司代码
	 */
	private String companyCode;

}
