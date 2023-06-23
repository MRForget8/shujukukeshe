package com.entity.view;

import com.entity.HuowujinkouEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 货物进口
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-07-24 19:54:51
 */
@TableName("huowujinkou")
public class HuowujinkouView  extends HuowujinkouEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public HuowujinkouView(){
	}
 
 	public HuowujinkouView(HuowujinkouEntity huowujinkouEntity){
 	try {
			BeanUtils.copyProperties(this, huowujinkouEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
