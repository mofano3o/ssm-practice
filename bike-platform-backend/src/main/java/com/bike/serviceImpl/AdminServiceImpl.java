package com.bike.serviceImpl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
    import com.bike.entity.*;
    import com.bike.mapper.*;
    import com.bike.service.*;
    import com.bike.common.*;
    import com.bike.request.*;

@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin add(Admin admin) {
        save(admin);
        return getById(admin.getId());
    }

    @Override
    public Admin update(Admin admin) {
        updateById(admin);
        return getById(admin.getId());
    }

    @Override
    public Admin detail(int id) {
        return getById(id);
    }

    @Override
    public void delete(int id) {
        getBaseMapper().deleteById(id);
    }

    @Override
    public ListResponse<Admin> list(ListAdminRequest request) {
        IPage<Admin> page = page(new Page<>(request.getPageNumber(), request.getPageSize()));
        return new ListResponse<>(page.getRecords(), page.getTotal());
    }
}
