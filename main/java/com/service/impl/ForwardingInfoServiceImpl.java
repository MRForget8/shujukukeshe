package com.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.ForwardingInfoDao;
import com.entity.ForwardingInfoEntity;
import com.service.ForwardingInfoService;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;


@Service
public class ForwardingInfoServiceImpl extends ServiceImpl<ForwardingInfoDao, ForwardingInfoEntity> implements ForwardingInfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        if (Objects.nonNull(params.get("isSearchAll")) && Boolean.valueOf(String.valueOf(params.get("isSearchAll")))) {
            List<ForwardingInfoEntity> list = this.selectList(null);
            return new PageUtils(list,0,0,0);
        }
        Page<ForwardingInfoEntity> page = this.selectPage(
                new Query<ForwardingInfoEntity>(params).getPage(),
                new EntityWrapper<ForwardingInfoEntity>().eq(StrUtil.isNotBlank(String.valueOf(params.get("key"))),"forwarding_company",params.get("key")));

        return new PageUtils(page);
    }

}