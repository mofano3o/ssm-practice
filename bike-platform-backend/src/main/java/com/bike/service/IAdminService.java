package com.bike.service;

import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;
    import com.bike.entity.*;
    import com.bike.mapper.*;
    import com.bike.service.*;
    import com.bike.common.*;
    import com.bike.request.*;

public interface IAdminService extends IService<Admin> {
        Admin add(Admin admin);
        Admin update(Admin admin);
        Admin detail(int id);
        void delete(int id);
        ListResponse<Admin> list(ListAdminRequest request);
}
