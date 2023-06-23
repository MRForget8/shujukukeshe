package com.entity;


import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;


@Data
@TableName("outbound")
public class OutboundEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 货代公司id
	 */
	private Integer forwardingCompanyId;
	/**
	 * 仓库编号
	 */
	private Integer storeNumber;
	/**
	 * 出库件数
	 */
	private Integer outboundNum;
	/**
	 * 出库时间
	 */
	private Date outboundDate;
	/**
	 * 出库吨数
	 */
	private String outboundTonnage;
	/**
	 * 堆存费
	 */
	private String storageFee;

}
