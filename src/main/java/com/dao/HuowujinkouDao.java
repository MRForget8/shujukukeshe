package com.dao;

import com.entity.HuowujinkouEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.HuowujinkouVO;
import com.entity.view.HuowujinkouView;


/**
 * 货物进口
 * 
 * @author 
 * @email 
 * @date 2022-07-24 19:54:51
 */
public interface HuowujinkouDao extends BaseMapper<HuowujinkouEntity> {
	
	List<HuowujinkouVO> selectListVO(@Param("ew") Wrapper<HuowujinkouEntity> wrapper);
	
	HuowujinkouVO selectVO(@Param("ew") Wrapper<HuowujinkouEntity> wrapper);
	
	List<HuowujinkouView> selectListView(@Param("ew") Wrapper<HuowujinkouEntity> wrapper);

	List<HuowujinkouView> selectListView(Pagination page,@Param("ew") Wrapper<HuowujinkouEntity> wrapper);
	
	HuowujinkouView selectView(@Param("ew") Wrapper<HuowujinkouEntity> wrapper);
	

}
