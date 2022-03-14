package com.bike.service;

import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

import com.bike.dto.OrderDto;
import com.bike.entity.*;
    import com.bike.mapper.*;
    import com.bike.service.*;
    import com.bike.common.*;
    import com.bike.request.*;

public interface IOrderService extends IService<Order> {
        Order add(Order order);
        Order update(Order order);
        Order detail(int id);
        void delete(int id);
        ListResponse<OrderDto> list(ListOrderRequest request);
}
