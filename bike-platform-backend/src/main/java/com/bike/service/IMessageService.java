package com.bike.service;

import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

import com.bike.dto.MessageDto;
import com.bike.entity.*;
    import com.bike.mapper.*;
    import com.bike.service.*;
    import com.bike.common.*;
    import com.bike.request.*;

public interface IMessageService extends IService<Message> {
        Message add(Message message);
        Message update(Message message);
        Message detail(int id);
        void delete(int id);
        ListResponse<MessageDto> list(ListMessageRequest request);
}
