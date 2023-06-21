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


import com.dao.HuowuchukouDao;
import com.entity.HuowuchukouEntity;
import com.service.HuowuchukouService;
import com.entity.vo.HuowuchukouVO;
import com.entity.view.HuowuchukouView;

@Service("huowuchukouService")
public class HuowuchukouServiceImpl extends ServiceImpl<HuowuchukouDao, HuowuchukouEntity> implements HuowuchukouService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<HuowuchukouEntity> page = this.selectPage(
                new Query<HuowuchukouEntity>(params).getPage(),
                new EntityWrapper<HuowuchukouEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<HuowuchukouEntity> wrapper) {
		  Page<HuowuchukouView> page =new Query<HuowuchukouView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<HuowuchukouVO> selectListVO(Wrapper<HuowuchukouEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public HuowuchukouVO selectVO(Wrapper<HuowuchukouEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<HuowuchukouView> selectListView(Wrapper<HuowuchukouEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public HuowuchukouView selectView(Wrapper<HuowuchukouEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
