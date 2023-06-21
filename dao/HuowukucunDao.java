package com.dao;

import com.entity.HuowukucunEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.HuowukucunVO;
import com.entity.view.HuowukucunView;


/**
 * 货物库存
 * 
 * @author 
 * @email 
 * @date 2022-07-24 19:54:51
 */
public interface HuowukucunDao extends BaseMapper<HuowukucunEntity> {
	
	List<HuowukucunVO> selectListVO(@Param("ew") Wrapper<HuowukucunEntity> wrapper);
	
	HuowukucunVO selectVO(@Param("ew") Wrapper<HuowukucunEntity> wrapper);
	
	List<HuowukucunView> selectListView(@Param("ew") Wrapper<HuowukucunEntity> wrapper);

	List<HuowukucunView> selectListView(Pagination page,@Param("ew") Wrapper<HuowukucunEntity> wrapper);
	
	HuowukucunView selectView(@Param("ew") Wrapper<HuowukucunEntity> wrapper);
	

}
