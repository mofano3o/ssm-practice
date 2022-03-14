package com.bike.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bike.dto.MessageDto;
import com.bike.entity.Message;
import org.apache.ibatis.annotations.Param;

public interface MessageMapper extends BaseMapper<Message> {
    IPage<MessageDto> findByUserId(Page<?> page, @Param("userId") int userId);
}
