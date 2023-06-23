package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ShugangxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ShugangxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ShugangxinxiView;


/**
 * 疏港信息
 *
 * @author 
 * @email 
 * @date 2022-07-24 19:54:51
 */
public interface ShugangxinxiService extends IService<ShugangxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShugangxinxiVO> selectListVO(Wrapper<ShugangxinxiEntity> wrapper);
   	
   	ShugangxinxiVO selectVO(@Param("ew") Wrapper<ShugangxinxiEntity> wrapper);
   	
   	List<ShugangxinxiView> selectListView(Wrapper<ShugangxinxiEntity> wrapper);
   	
   	ShugangxinxiView selectView(@Param("ew") Wrapper<ShugangxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShugangxinxiEntity> wrapper);
   	

}

