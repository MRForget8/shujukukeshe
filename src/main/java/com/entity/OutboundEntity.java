package com.entity;


import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;


@Data
@TableName("outbound")
public class OutboundEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId(type = IdType.AUTO)
	private Integer id;
	/**
	 * 货代公司id
	 */
	private Integer forwardingCompanyId;
	/**
	 * 仓库编号
	 */
	private String storeNumber;
	/**
	 * 出库件数
	 */
	private Integer outboundNum;
	/**
	 * 出库时间
	 */
	private String outboundDate;
	/**
	 * 出库吨数
	 */
	private Double outboundTonnage;
	/**
	 * 堆存费
	 */
	private Double storageFee;

}
