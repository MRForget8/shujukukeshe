package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.HuowujinkouEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.HuowujinkouVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.HuowujinkouView;


/**
 * 货物进口
 *
 * @author 
 * @email 
 * @date 2022-07-24 19:54:51
 */
public interface HuowujinkouService extends IService<HuowujinkouEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<HuowujinkouVO> selectListVO(Wrapper<HuowujinkouEntity> wrapper);
   	
   	HuowujinkouVO selectVO(@Param("ew") Wrapper<HuowujinkouEntity> wrapper);
   	
   	List<HuowujinkouView> selectListView(Wrapper<HuowujinkouEntity> wrapper);
   	
   	HuowujinkouView selectView(@Param("ew") Wrapper<HuowujinkouEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<HuowujinkouEntity> wrapper);
   	

}

