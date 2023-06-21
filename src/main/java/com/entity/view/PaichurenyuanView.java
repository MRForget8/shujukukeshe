package com.entity.view;

import com.entity.PaichurenyuanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 派出人员
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-07-24 19:54:51
 */
@TableName("paichurenyuan")
public class PaichurenyuanView  extends PaichurenyuanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public PaichurenyuanView(){
	}
 
 	public PaichurenyuanView(PaichurenyuanEntity paichurenyuanEntity){
 	try {
			BeanUtils.copyProperties(this, paichurenyuanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
