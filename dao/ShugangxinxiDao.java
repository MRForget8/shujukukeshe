package com.dao;

import com.entity.ShugangxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ShugangxinxiVO;
import com.entity.view.ShugangxinxiView;


/**
 * 疏港信息
 * 
 * @author 
 * @email 
 * @date 2022-07-24 19:54:51
 */
public interface ShugangxinxiDao extends BaseMapper<ShugangxinxiEntity> {
	
	List<ShugangxinxiVO> selectListVO(@Param("ew") Wrapper<ShugangxinxiEntity> wrapper);
	
	ShugangxinxiVO selectVO(@Param("ew") Wrapper<ShugangxinxiEntity> wrapper);
	
	List<ShugangxinxiView> selectListView(@Param("ew") Wrapper<ShugangxinxiEntity> wrapper);

	List<ShugangxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<ShugangxinxiEntity> wrapper);
	
	ShugangxinxiView selectView(@Param("ew") Wrapper<ShugangxinxiEntity> wrapper);
	

}
