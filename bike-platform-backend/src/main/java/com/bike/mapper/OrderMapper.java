package com.bike.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bike.dto.OrderDto;
import com.bike.entity.Order;

public interface OrderMapper extends BaseMapper<Order> {
    IPage<OrderDto> findAll(Page<?> page);
}
