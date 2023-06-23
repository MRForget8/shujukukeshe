package com.dao;

import com.entity.PaichurenyuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.PaichurenyuanVO;
import com.entity.view.PaichurenyuanView;


/**
 * 派出人员
 * 
 * @author 
 * @email 
 * @date 2022-07-24 19:54:51
 */
public interface PaichurenyuanDao extends BaseMapper<PaichurenyuanEntity> {
	
	List<PaichurenyuanVO> selectListVO(@Param("ew") Wrapper<PaichurenyuanEntity> wrapper);
	
	PaichurenyuanVO selectVO(@Param("ew") Wrapper<PaichurenyuanEntity> wrapper);
	
	List<PaichurenyuanView> selectListView(@Param("ew") Wrapper<PaichurenyuanEntity> wrapper);

	List<PaichurenyuanView> selectListView(Pagination page,@Param("ew") Wrapper<PaichurenyuanEntity> wrapper);
	
	PaichurenyuanView selectView(@Param("ew") Wrapper<PaichurenyuanEntity> wrapper);
	

}
