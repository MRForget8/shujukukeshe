package com.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.WarehousingDao;
import com.entity.WarehousingEntity;
import com.service.WarehousingService;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;


@Service
public class WarehousingServiceImpl extends ServiceImpl<WarehousingDao, WarehousingEntity> implements WarehousingService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<WarehousingEntity> page = this.selectPage(
                new Query<WarehousingEntity>(params).getPage(),
                new EntityWrapper<WarehousingEntity>()
        );

        return new PageUtils(page);
    }

}