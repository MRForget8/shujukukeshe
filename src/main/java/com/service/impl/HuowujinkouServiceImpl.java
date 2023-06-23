package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.HuowujinkouDao;
import com.entity.HuowujinkouEntity;
import com.service.HuowujinkouService;
import com.entity.vo.HuowujinkouVO;
import com.entity.view.HuowujinkouView;

@Service("huowujinkouService")
public class HuowujinkouServiceImpl extends ServiceImpl<HuowujinkouDao, HuowujinkouEntity> implements HuowujinkouService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<HuowujinkouEntity> page = this.selectPage(
                new Query<HuowujinkouEntity>(params).getPage(),
                new EntityWrapper<HuowujinkouEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<HuowujinkouEntity> wrapper) {
		  Page<HuowujinkouView> page =new Query<HuowujinkouView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<HuowujinkouVO> selectListVO(Wrapper<HuowujinkouEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public HuowujinkouVO selectVO(Wrapper<HuowujinkouEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<HuowujinkouView> selectListView(Wrapper<HuowujinkouEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public HuowujinkouView selectView(Wrapper<HuowujinkouEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
