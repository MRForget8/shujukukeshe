package com.service;


import com.baomidou.mybatisplus.service.IService;
import com.entity.ForwardingInfoEntity;
import com.utils.PageUtils;

import java.util.Map;


public interface ForwardingInfoService extends IService<ForwardingInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

