package com.service;


import com.baomidou.mybatisplus.service.IService;
import com.entity.ForwardingInfoEntity;
import com.utils.PageUtils;

import java.util.Map;

/**
 * 货代公司信息
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2023-06-21 18:57:01
 */
public interface ForwardingInfoService extends IService<ForwardingInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

