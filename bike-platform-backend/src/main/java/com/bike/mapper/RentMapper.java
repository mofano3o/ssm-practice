package com.bike.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bike.dto.RentDto;
import com.bike.entity.Rent;

import java.util.List;

public interface RentMapper extends BaseMapper<Rent> {
    IPage<RentDto> findAll(Page<?> page);
}
