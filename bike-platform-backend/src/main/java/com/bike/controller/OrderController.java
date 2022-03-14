package com.bike.controller;

    import com.bike.dto.OrderDto;
    import com.bike.serviceImpl.*;
    import com.bike.service.*;
    import com.bike.common.*;
    import com.bike.request.*;
    import com.bike.entity.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @PostMapping("/add")
    public Response<Order> add(@RequestBody Order request) {
        Order order = orderService.add(request);
        return Response.ok(order);
    }

    @PutMapping("/update")
    public Response<Order> update(@RequestBody Order old) {
        Order order = orderService.update(old);
        return Response.ok(order);
    }

    @GetMapping("/{id}")
    public Response<Order> detail(@PathVariable int id) {
        return Response.ok(orderService.detail(id));
    }

    @DeleteMapping("/{id}")
    public Response<String> delete(@PathVariable int id) {
        orderService.delete(id);
        return Response.ok();
    }

    @PostMapping("/list")
    public Response<ListResponse<OrderDto>> list(@RequestBody ListOrderRequest request) {
        return Response.ok(orderService.list(request));
    }

}
