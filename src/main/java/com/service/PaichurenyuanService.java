package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.PaichurenyuanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.PaichurenyuanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.PaichurenyuanView;


/**
 * 派出人员
 *
 * @author 
 * @email 
 * @date 2022-07-24 19:54:51
 */
public interface PaichurenyuanService extends IService<PaichurenyuanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<PaichurenyuanVO> selectListVO(Wrapper<PaichurenyuanEntity> wrapper);
   	
   	PaichurenyuanVO selectVO(@Param("ew") Wrapper<PaichurenyuanEntity> wrapper);
   	
   	List<PaichurenyuanView> selectListView(Wrapper<PaichurenyuanEntity> wrapper);
   	
   	PaichurenyuanView selectView(@Param("ew") Wrapper<PaichurenyuanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<PaichurenyuanEntity> wrapper);
   	

}

