package com.dao;

import com.entity.HuowuchukouEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.HuowuchukouVO;
import com.entity.view.HuowuchukouView;


/**
 * 货物出口
 * 
 * @author 
 * @email 
 * @date 2022-07-24 19:54:51
 */
public interface HuowuchukouDao extends BaseMapper<HuowuchukouEntity> {
	
	List<HuowuchukouVO> selectListVO(@Param("ew") Wrapper<HuowuchukouEntity> wrapper);
	
	HuowuchukouVO selectVO(@Param("ew") Wrapper<HuowuchukouEntity> wrapper);
	
	List<HuowuchukouView> selectListView(@Param("ew") Wrapper<HuowuchukouEntity> wrapper);

	List<HuowuchukouView> selectListView(Pagination page,@Param("ew") Wrapper<HuowuchukouEntity> wrapper);
	
	HuowuchukouView selectView(@Param("ew") Wrapper<HuowuchukouEntity> wrapper);
	

}
