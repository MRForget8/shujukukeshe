package com.entity.view;

import com.entity.HangxianfenleiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 航线分类
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-07-24 19:54:51
 */
@TableName("hangxianfenlei")
public class HangxianfenleiView  extends HangxianfenleiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public HangxianfenleiView(){
	}
 
 	public HangxianfenleiView(HangxianfenleiEntity hangxianfenleiEntity){
 	try {
			BeanUtils.copyProperties(this, hangxianfenleiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
