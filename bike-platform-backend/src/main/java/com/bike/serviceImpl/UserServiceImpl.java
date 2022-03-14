package com.bike.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bike.dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
    import com.bike.entity.*;
    import com.bike.mapper.*;
    import com.bike.service.*;
    import com.bike.common.*;
    import com.bike.request.*;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public User add(User user) {
        save(user);
        return getById(user.getId());
    }

    @Override
    public User update(User user) {
        updateById(user);
        return getById(user.getId());
    }

    @Override
    public User detail(int id) {
        return getById(id);
    }

    @Override
    public void delete(int id) {
        getBaseMapper().deleteById(id);
    }

    @Override
    public ListResponse<User> list(ListUserRequest request) {
        IPage<User> page = page(new Page<>(request.getPageNumber(), request.getPageSize()));
        return new ListResponse<>(page.getRecords(), page.getTotal());
    }

    @Override
    public UserDto login(LoginRequest request) {
        UserDto dto = new UserDto();
        if (request.getType() == 0) {
            QueryWrapper<Admin> wrapper = new QueryWrapper<>();
            wrapper.eq("name", request.getName())
                    .eq("password", request.getPassword());
            Admin admin = adminMapper.selectOne(wrapper);
            if (admin == null) {
                throw new RuntimeException("用户名或密码错误");
            }
            dto.setName(admin.getName());
            dto.setType(0);
            return dto;
        }
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("name", request.getName())
                .eq("password", request.getPassword());
        User user = userMapper.selectOne(userQueryWrapper);
        if (user == null) {
            throw new RuntimeException("用户名或密码错误");
        }
        if (user.getStatus() == 0) {
            throw new RuntimeException("认证未通过");
        }

        BeanUtils.copyProperties(user, dto);
        dto.setType(1);
        return dto;
    }

    @Override
    public void accept(int id) {
        User user = getById(id);
        user.setStatus(1);
        updateById(user);
    }
}
