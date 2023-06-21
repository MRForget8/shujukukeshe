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


import com.dao.PaichurenyuanDao;
import com.entity.PaichurenyuanEntity;
import com.service.PaichurenyuanService;
import com.entity.vo.PaichurenyuanVO;
import com.entity.view.PaichurenyuanView;

@Service("paichurenyuanService")
public class PaichurenyuanServiceImpl extends ServiceImpl<PaichurenyuanDao, PaichurenyuanEntity> implements PaichurenyuanService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<PaichurenyuanEntity> page = this.selectPage(
                new Query<PaichurenyuanEntity>(params).getPage(),
                new EntityWrapper<PaichurenyuanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<PaichurenyuanEntity> wrapper) {
		  Page<PaichurenyuanView> page =new Query<PaichurenyuanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<PaichurenyuanVO> selectListVO(Wrapper<PaichurenyuanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public PaichurenyuanVO selectVO(Wrapper<PaichurenyuanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<PaichurenyuanView> selectListView(Wrapper<PaichurenyuanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public PaichurenyuanView selectView(Wrapper<PaichurenyuanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
