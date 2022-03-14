package com.bike.controller;

    import com.bike.dto.UserDto;
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
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("/add")
    public Response<User> add(@RequestBody User request) {
        User user = userService.add(request);
        return Response.ok(user);
    }

    @PutMapping("/update")
    public Response<User> update(@RequestBody User old) {
        User user = userService.update(old);
        return Response.ok(user);
    }

    @GetMapping("/{id}")
    public Response<User> detail(@PathVariable int id) {
        return Response.ok(userService.detail(id));
    }

    @DeleteMapping("/{id}")
    public Response<String> delete(@PathVariable int id) {
        userService.delete(id);
        return Response.ok();
    }

    @PostMapping("/list")
    public Response<ListResponse<User>> list(@RequestBody ListUserRequest request) {
        return Response.ok(userService.list(request));
    }

    @PostMapping("/login")
    public Response<UserDto> login (@RequestBody LoginRequest request) {
        return Response.ok(userService.login(request));
    }

    @GetMapping("/accept/{id}")
    public Response<String> accept(@PathVariable int id) {
        userService.accept(id);
        return Response.ok();
    }

}
