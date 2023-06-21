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


import com.dao.HuowukucunDao;
import com.entity.HuowukucunEntity;
import com.service.HuowukucunService;
import com.entity.vo.HuowukucunVO;
import com.entity.view.HuowukucunView;

@Service("huowukucunService")
public class HuowukucunServiceImpl extends ServiceImpl<HuowukucunDao, HuowukucunEntity> implements HuowukucunService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<HuowukucunEntity> page = this.selectPage(
                new Query<HuowukucunEntity>(params).getPage(),
                new EntityWrapper<HuowukucunEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<HuowukucunEntity> wrapper) {
		  Page<HuowukucunView> page =new Query<HuowukucunView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<HuowukucunVO> selectListVO(Wrapper<HuowukucunEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public HuowukucunVO selectVO(Wrapper<HuowukucunEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<HuowukucunView> selectListView(Wrapper<HuowukucunEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public HuowukucunView selectView(Wrapper<HuowukucunEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
