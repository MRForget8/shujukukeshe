package com.service;


import com.baomidou.mybatisplus.service.IService;
import com.entity.WarehousingEntity;
import com.utils.PageUtils;

import java.util.Map;


public interface WarehousingService extends IService<WarehousingEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

