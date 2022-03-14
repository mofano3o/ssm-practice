package com.bike.serviceImpl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bike.dto.MessageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
    import com.bike.entity.*;
    import com.bike.mapper.*;
    import com.bike.service.*;
    import com.bike.common.*;
    import com.bike.request.*;

@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message> implements IMessageService {
    @Autowired
    private MessageMapper messageMapper;

    @Override
    public Message add(Message message) {
        save(message);
        return getById(message.getId());
    }

    @Override
    public Message update(Message message) {
        updateById(message);
        return getById(message.getId());
    }

    @Override
    public Message detail(int id) {
        return getById(id);
    }

    @Override
    public void delete(int id) {
        getBaseMapper().deleteById(id);
    }

    @Override
    public ListResponse<MessageDto> list(ListMessageRequest request) {
        IPage<MessageDto> page = messageMapper.findByUserId(
                new Page<>(request.getPageNumber(), request.getPageSize()), request.getUserId());
        return new ListResponse<>(page.getRecords(), page.getTotal());
    }
}
