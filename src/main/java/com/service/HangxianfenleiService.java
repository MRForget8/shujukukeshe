package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.HangxianfenleiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.HangxianfenleiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.HangxianfenleiView;


/**
 * 航线分类
 *
 * @author 
 * @email 
 * @date 2022-07-24 19:54:51
 */
public interface HangxianfenleiService extends IService<HangxianfenleiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<HangxianfenleiVO> selectListVO(Wrapper<HangxianfenleiEntity> wrapper);
   	
   	HangxianfenleiVO selectVO(@Param("ew") Wrapper<HangxianfenleiEntity> wrapper);
   	
   	List<HangxianfenleiView> selectListView(Wrapper<HangxianfenleiEntity> wrapper);
   	
   	HangxianfenleiView selectView(@Param("ew") Wrapper<HangxianfenleiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<HangxianfenleiEntity> wrapper);
   	

}

