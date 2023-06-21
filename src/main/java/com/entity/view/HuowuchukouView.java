package com.entity.view;

import com.entity.HuowuchukouEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 货物出口
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-07-24 19:54:51
 */
@TableName("huowuchukou")
public class HuowuchukouView  extends HuowuchukouEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public HuowuchukouView(){
	}
 
 	public HuowuchukouView(HuowuchukouEntity huowuchukouEntity){
 	try {
			BeanUtils.copyProperties(this, huowuchukouEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
