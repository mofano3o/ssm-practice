package com.bike.serviceImpl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bike.dto.RentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
    import com.bike.entity.*;
    import com.bike.mapper.*;
    import com.bike.service.*;
    import com.bike.common.*;
    import com.bike.request.*;

@Service
public class RentServiceImpl extends ServiceImpl<RentMapper, Rent> implements IRentService {
    @Autowired
    private RentMapper rentMapper;

    @Override
    public Rent add(Rent rent) {
        save(rent);
        return getById(rent.getId());
    }

    @Override
    public Rent update(Rent rent) {
        updateById(rent);
        return getById(rent.getId());
    }

    @Override
    public Rent detail(int id) {
        return getById(id);
    }

    @Override
    public void delete(int id) {
        getBaseMapper().deleteById(id);
    }

    @Override
    public ListResponse<RentDto> list(ListRentRequest request) {
        IPage<RentDto> page = rentMapper.findAll(new Page<>(request.getPageNumber(), request.getPageSize()));
        return new ListResponse<>(page.getRecords(), page.getTotal());
    }
}
