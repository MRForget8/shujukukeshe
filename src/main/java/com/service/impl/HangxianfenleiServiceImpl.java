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


import com.dao.HangxianfenleiDao;
import com.entity.HangxianfenleiEntity;
import com.service.HangxianfenleiService;
import com.entity.vo.HangxianfenleiVO;
import com.entity.view.HangxianfenleiView;

@Service("hangxianfenleiService")
public class HangxianfenleiServiceImpl extends ServiceImpl<HangxianfenleiDao, HangxianfenleiEntity> implements HangxianfenleiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<HangxianfenleiEntity> page = this.selectPage(
                new Query<HangxianfenleiEntity>(params).getPage(),
                new EntityWrapper<HangxianfenleiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<HangxianfenleiEntity> wrapper) {
		  Page<HangxianfenleiView> page =new Query<HangxianfenleiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<HangxianfenleiVO> selectListVO(Wrapper<HangxianfenleiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public HangxianfenleiVO selectVO(Wrapper<HangxianfenleiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<HangxianfenleiView> selectListView(Wrapper<HangxianfenleiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public HangxianfenleiView selectView(Wrapper<HangxianfenleiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
