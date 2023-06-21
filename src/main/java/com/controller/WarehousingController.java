package com.controller;

import java.util.Arrays;
import java.util.Map;

import com.entity.WarehousingEntity;
import com.service.WarehousingService;
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
@RequestMapping("/warehousing")
public class WarehousingController {

    @Autowired
    private WarehousingService warehousingService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = warehousingService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
		WarehousingEntity warehousing = warehousingService.selectById(id);

        return R.ok().put("warehousing", warehousing);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody WarehousingEntity warehousing){
		warehousingService.insert(warehousing);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody WarehousingEntity warehousing){
		warehousingService.updateById(warehousing);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
		warehousingService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
