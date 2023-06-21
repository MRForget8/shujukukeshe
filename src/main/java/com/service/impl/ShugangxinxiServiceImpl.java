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


import com.dao.ShugangxinxiDao;
import com.entity.ShugangxinxiEntity;
import com.service.ShugangxinxiService;
import com.entity.vo.ShugangxinxiVO;
import com.entity.view.ShugangxinxiView;

@Service("shugangxinxiService")
public class ShugangxinxiServiceImpl extends ServiceImpl<ShugangxinxiDao, ShugangxinxiEntity> implements ShugangxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShugangxinxiEntity> page = this.selectPage(
                new Query<ShugangxinxiEntity>(params).getPage(),
                new EntityWrapper<ShugangxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShugangxinxiEntity> wrapper) {
		  Page<ShugangxinxiView> page =new Query<ShugangxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ShugangxinxiVO> selectListVO(Wrapper<ShugangxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ShugangxinxiVO selectVO(Wrapper<ShugangxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ShugangxinxiView> selectListView(Wrapper<ShugangxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShugangxinxiView selectView(Wrapper<ShugangxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
