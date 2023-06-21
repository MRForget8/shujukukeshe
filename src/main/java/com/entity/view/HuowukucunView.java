package com.entity.view;

import com.entity.HuowukucunEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 货物库存
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-07-24 19:54:51
 */
@TableName("huowukucun")
public class HuowukucunView  extends HuowukucunEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public HuowukucunView(){
	}
 
 	public HuowukucunView(HuowukucunEntity huowukucunEntity){
 	try {
			BeanUtils.copyProperties(this, huowukucunEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
