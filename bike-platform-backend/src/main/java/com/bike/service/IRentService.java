package com.bike.service;

import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

import com.bike.dto.RentDto;
import com.bike.entity.*;
    import com.bike.mapper.*;
    import com.bike.service.*;
    import com.bike.common.*;
    import com.bike.request.*;

public interface IRentService extends IService<Rent> {
        Rent add(Rent rent);
        Rent update(Rent rent);
        Rent detail(int id);
        void delete(int id);
        ListResponse<RentDto> list(ListRentRequest request);
}
