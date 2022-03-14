package com.bike.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;

public class Message extends Model<Message> {

    private static final long serialVersionUID = 1L;

            @TableId(value = "id", type = IdType.AUTO)
        private Integer id;
        private Integer userId;
        private Integer targetId;
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
            public Integer getUserId() {
                return this.userId;
            }
            public void setUserId(Integer userId) {
                this.userId = userId;
            }
            public Integer getTargetId() {
                return this.targetId;
            }
            public void setTargetId(Integer targetId) {
                this.targetId = targetId;
            }
}