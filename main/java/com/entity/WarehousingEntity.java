package com.entity;


import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;


@Data
@TableName("warehousing")
public class WarehousingEntity implements Serializable {
	private static final long serialVersionUID = 1L;


	@TableId(type = IdType.AUTO)
	private Integer id;
	/**
	 * 货代公司id
	 */
	private Integer forwardingCompanyId;
	/**
	 * 车牌号
	 */
	private String carNumber;
	/**
	 * 入库件数
	 */
	private Integer warehousingNum;
	/**
	 * 入库时间
	 */
	private String warehousingDate;
	/**
	 * 入库吨数
	 */
	private Double warehousingTonnage;
	/**
	 * 仓库编号
	 */
	private String storeNumber;

}
