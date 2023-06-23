package com.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.ForwardingInfoDao;
import com.entity.ForwardingInfoEntity;
import com.service.ForwardingInfoService;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;


@Service
public class ForwardingInfoServiceImpl extends ServiceImpl<ForwardingInfoDao, ForwardingInfoEntity> implements ForwardingInfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ForwardingInfoEntity> page = this.selectPage(
                new Query<ForwardingInfoEntity>(params).getPage(),
                new EntityWrapper<>()
        );

        return new PageUtils(page);
    }

}