package com.bike.controller;

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
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private IAdminService adminService;

    @PostMapping("/add")
    public Response<Admin> add(@RequestBody Admin request) {
        Admin admin = adminService.add(request);
        return Response.ok(admin);
    }

    @PutMapping("/update")
    public Response<Admin> update(@RequestBody Admin old) {
        Admin admin = adminService.update(old);
        return Response.ok(admin);
    }

    @GetMapping("/{id}")
    public Response<Admin> detail(@PathVariable int id) {
        return Response.ok(adminService.detail(id));
    }

    @DeleteMapping("/{id}")
    public Response<String> delete(@PathVariable int id) {
        adminService.delete(id);
        return Response.ok();
    }

    @PostMapping("/list")
    public Response<ListResponse<Admin>> list(@RequestBody ListAdminRequest request) {
        return Response.ok(adminService.list(request));
    }

}
