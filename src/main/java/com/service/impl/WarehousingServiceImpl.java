package com.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.WarehousingDao;
import com.entity.ForwardingInfoEntity;
import com.entity.WarehousingEntity;
import com.service.WarehousingService;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.stereotype.Service;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;


@Service
public class WarehousingServiceImpl extends ServiceImpl<WarehousingDao, WarehousingEntity> implements WarehousingService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        if (Objects.nonNull(params.get("isSearchAll")) && Boolean.valueOf(String.valueOf(params.get("isSearchAll")))) {
            List<WarehousingEntity> list = this.selectList(new EntityWrapper<WarehousingEntity>()
                    .eq(StrUtil.isNotBlank(String.valueOf(params.get("key"))),"forwarding_company_id",params.get("key")));
            return new PageUtils(list,0,0,0);
        }
        Page<WarehousingEntity> page = this.selectPage(
                new Query<WarehousingEntity>(params).getPage(),
                new EntityWrapper<WarehousingEntity>()
                        .eq(StrUtil.isNotBlank(String.valueOf(params.get("key"))),"car_number",params.get("key"))
        );

        return new PageUtils(page);
    }

    @Override
    public Map<String, Double> getStorageFeeGroupStoreNumber(Map<String, Object> params) {
        List<WarehousingEntity> warehousingEntityList = this.selectList(new EntityWrapper<>());
        Map<String, Double> result = warehousingEntityList.stream()
                .collect(Collectors.groupingBy(WarehousingEntity::getStoreNumber,
                        Collectors.summingDouble(WarehousingEntity::getWarehousingTonnage)));
        return result;
    }

}