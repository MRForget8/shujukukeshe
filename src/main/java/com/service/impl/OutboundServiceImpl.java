package com.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.OutboundDao;
import com.entity.ForwardingInfoEntity;
import com.entity.OutboundEntity;
import com.entity.WarehousingEntity;
import com.service.OutboundService;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;


@Service
public class OutboundServiceImpl extends ServiceImpl<OutboundDao, OutboundEntity> implements OutboundService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        if (Objects.nonNull(params.get("isSearchAll")) && Boolean.valueOf(String.valueOf(params.get("isSearchAll")))) {
            List<OutboundEntity> list = this.selectList(new EntityWrapper<OutboundEntity>()
                    .eq(StrUtil.isNotBlank(String.valueOf(params.get("key"))),"forwarding_company_id",params.get("key")));
            return new PageUtils(list,0,0,0);
        }
        Page<OutboundEntity> page = this.selectPage(
                new Query<OutboundEntity>(params).getPage(),
                new EntityWrapper<OutboundEntity>()
                        .eq(StrUtil.isNotBlank(String.valueOf(params.get("key"))),"store_number",params.get("key"))
        );

        return new PageUtils(page);
    }

}