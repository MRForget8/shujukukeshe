package com.service;


import com.baomidou.mybatisplus.service.IService;
import com.entity.OutboundEntity;
import com.utils.PageUtils;

import java.util.Map;


public interface OutboundService extends IService<OutboundEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

