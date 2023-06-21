package com.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.OutboundDao;
import com.entity.OutboundEntity;
import com.service.OutboundService;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;


@Service
public class OutboundServiceImpl extends ServiceImpl<OutboundDao, OutboundEntity> implements OutboundService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<OutboundEntity> page = this.selectPage(
                new Query<OutboundEntity>(params).getPage(),
                new EntityWrapper<OutboundEntity>()
        );

        return new PageUtils(page);
    }

}