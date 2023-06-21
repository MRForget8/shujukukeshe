package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.HuowuchukouEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.HuowuchukouVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.HuowuchukouView;


/**
 * 货物出口
 *
 * @author 
 * @email 
 * @date 2022-07-24 19:54:51
 */
public interface HuowuchukouService extends IService<HuowuchukouEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<HuowuchukouVO> selectListVO(Wrapper<HuowuchukouEntity> wrapper);
   	
   	HuowuchukouVO selectVO(@Param("ew") Wrapper<HuowuchukouEntity> wrapper);
   	
   	List<HuowuchukouView> selectListView(Wrapper<HuowuchukouEntity> wrapper);
   	
   	HuowuchukouView selectView(@Param("ew") Wrapper<HuowuchukouEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<HuowuchukouEntity> wrapper);
   	

}

