package com.dao;

import com.entity.HangxianfenleiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.HangxianfenleiVO;
import com.entity.view.HangxianfenleiView;


/**
 * 航线分类
 * 
 * @author 
 * @email 
 * @date 2022-07-24 19:54:51
 */
public interface HangxianfenleiDao extends BaseMapper<HangxianfenleiEntity> {
	
	List<HangxianfenleiVO> selectListVO(@Param("ew") Wrapper<HangxianfenleiEntity> wrapper);
	
	HangxianfenleiVO selectVO(@Param("ew") Wrapper<HangxianfenleiEntity> wrapper);
	
	List<HangxianfenleiView> selectListView(@Param("ew") Wrapper<HangxianfenleiEntity> wrapper);

	List<HangxianfenleiView> selectListView(Pagination page,@Param("ew") Wrapper<HangxianfenleiEntity> wrapper);
	
	HangxianfenleiView selectView(@Param("ew") Wrapper<HangxianfenleiEntity> wrapper);
	

}
