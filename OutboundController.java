package com.controller;

import java.util.Arrays;
import java.util.Map;

import com.entity.OutboundEntity;
import com.service.OutboundService;
import com.utils.PageUtils;
import com.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
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
		outboundService.insert(outbound);

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
