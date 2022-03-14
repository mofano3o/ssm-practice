package com.bike.controller;

    import com.bike.dto.RentDto;
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
@RequestMapping("/rent")
public class RentController {

    @Autowired
    private IRentService rentService;

    @PostMapping("/add")
    public Response<Rent> add(@RequestBody Rent request) {
        Rent rent = rentService.add(request);
        return Response.ok(rent);
    }

    @PutMapping("/update")
    public Response<Rent> update(@RequestBody Rent old) {
        Rent rent = rentService.update(old);
        return Response.ok(rent);
    }

    @GetMapping("/{id}")
    public Response<Rent> detail(@PathVariable int id) {
        return Response.ok(rentService.detail(id));
    }

    @DeleteMapping("/{id}")
    public Response<String> delete(@PathVariable int id) {
        rentService.delete(id);
        return Response.ok();
    }

    @PostMapping("/list")
    public Response<ListResponse<RentDto>> list(@RequestBody ListRentRequest request) {
        return Response.ok(rentService.list(request));
    }

}
