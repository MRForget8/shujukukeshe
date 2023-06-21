package com.controller;

import java.util.Arrays;
import java.util.Map;

import com.entity.ForwardingInfoEntity;
import com.service.ForwardingInfoService;
import com.utils.PageUtils;
import com.utils.R;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("/forwardinginfo")
public class ForwardingInfoController {
    @Autowired
    private ForwardingInfoService forwardingInfoService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = forwardingInfoService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
		ForwardingInfoEntity forwardingInfo = forwardingInfoService.selectById(id);

        return R.ok().put("forwardingInfo", forwardingInfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ForwardingInfoEntity forwardingInfo){
		forwardingInfoService.insert(forwardingInfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody ForwardingInfoEntity forwardingInfo){
		forwardingInfoService.updateById(forwardingInfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
		forwardingInfoService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
