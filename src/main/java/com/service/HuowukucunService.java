package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.HuowukucunEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.HuowukucunVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.HuowukucunView;


/**
 * 货物库存
 *
 * @author 
 * @email 
 * @date 2022-07-24 19:54:51
 */
public interface HuowukucunService extends IService<HuowukucunEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<HuowukucunVO> selectListVO(Wrapper<HuowukucunEntity> wrapper);
   	
   	HuowukucunVO selectVO(@Param("ew") Wrapper<HuowukucunEntity> wrapper);
   	
   	List<HuowukucunView> selectListView(Wrapper<HuowukucunEntity> wrapper);
   	
   	HuowukucunView selectView(@Param("ew") Wrapper<HuowukucunEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<HuowukucunEntity> wrapper);
   	

}

