package com.bike.service;

import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

import com.bike.dto.UserDto;
import com.bike.entity.*;
    import com.bike.mapper.*;
    import com.bike.service.*;
    import com.bike.common.*;
    import com.bike.request.*;

public interface IUserService extends IService<User> {
        User add(User user);
        User update(User user);
        User detail(int id);
        void delete(int id);
        ListResponse<User> list(ListUserRequest request);

    UserDto login(LoginRequest request);

    void accept(int id);
}
