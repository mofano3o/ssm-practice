package com.bike.serviceImpl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bike.dto.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
    import com.bike.entity.*;
    import com.bike.mapper.*;
    import com.bike.service.*;
    import com.bike.common.*;
    import com.bike.request.*;

@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public Order add(Order order) {
        save(order);
        return getById(order.getId());
    }

    @Override
    public Order update(Order order) {
        updateById(order);
        return getById(order.getId());
    }

    @Override
    public Order detail(int id) {
        return getById(id);
    }

    @Override
    public void delete(int id) {
        getBaseMapper().deleteById(id);
    }

    @Override
    public ListResponse<OrderDto> list(ListOrderRequest request) {
        IPage<OrderDto> page = orderMapper.findAll(new Page<>(request.getPageNumber(), request.getPageSize()));
        return new ListResponse<>(page.getRecords(), page.getTotal());
    }
}
