package com.entity.view;

import com.entity.ShugangxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 疏港信息
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-07-24 19:54:51
 */
@TableName("shugangxinxi")
public class ShugangxinxiView  extends ShugangxinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ShugangxinxiView(){
	}
 
 	public ShugangxinxiView(ShugangxinxiEntity shugangxinxiEntity){
 	try {
			BeanUtils.copyProperties(this, shugangxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
