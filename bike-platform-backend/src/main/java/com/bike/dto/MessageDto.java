package com.bike.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;

public class MessageDto extends Model<MessageDto> {

    private static final long serialVersionUID = 1L;

            @TableId(value = "id", type = IdType.AUTO)
        private Integer id;
        private String user;
        private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getId() {
                return this.id;
            }

    public void setId(Integer id) {
                this.id = id;
            }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}