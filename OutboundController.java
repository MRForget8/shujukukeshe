package com.controller;

import java.util.*;
import java.util.stream.Collectors;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.entity.OutboundEntity;
import com.entity.StoreInfoEntity;
import com.entity.WarehousingEntity;
import com.service.OutboundService;
import com.service.StoreInfoService;
import com.service.WarehousingService;
import com.utils.PageUtils;
import com.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("/outbound")
public class OutboundController {

    @Autowired
    private OutboundService outboundService;

    @Autowired
    private StoreInfoService storeInfoService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = outboundService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
		OutboundEntity outbound = outboundService.selectById(id);

        return R.ok().put("outbound", outbound);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody OutboundEntity outbound){
        // 1. 获取指定仓库的入库数据
        StoreInfoEntity storeInfo =
                storeInfoService.selectOne(
                        new EntityWrapper<StoreInfoEntity>()
                                .eq("store_number", outbound.getStoreNumber()));
        if (Objects.isNull(storeInfo)) {
            return R.error("仓库错误");
        }

        // 2. 检验出库数量合法性
        if (outbound.getOutboundNum() > storeInfo.getStoreNum()) {
            return R.error("出库件数不能大于入库件数");
        }
        if (outbound.getOutboundTonnage() > storeInfo.getStoreTonnage()) {
            return R.error("出库吨数不能大于入库吨数");
        }
        outboundService.insert(outbound);

        // 3. 计算剩余库存数量
        StoreInfoEntity storeInfoEntity = new StoreInfoEntity();
        storeInfoEntity.setStoreNum(outbound.getOutboundNum() - storeInfo.getStoreNum());
        storeInfoEntity.setStoreTonnage(outbound.getOutboundTonnage() - storeInfo.getStoreTonnage());
        storeInfoService.update(storeInfoEntity,new EntityWrapper<StoreInfoEntity>().eq("store_number",outbound.getStoreNumber()));

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody OutboundEntity outbound){
		outboundService.updateById(outbound);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
		outboundService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
