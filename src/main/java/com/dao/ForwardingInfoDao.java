package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.entity.ForwardingInfoEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 货代公司信息
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2023-06-21 18:57:01
 */
@Mapper
public interface ForwardingInfoDao extends BaseMapper<ForwardingInfoEntity> {
	
}
