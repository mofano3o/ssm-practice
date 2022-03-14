package com.bike.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;

public class Rent extends Model<Rent> {

    private static final long serialVersionUID = 1L;

            @TableId(value = "id", type = IdType.AUTO)
        private Integer id;
        private Integer userId;
        private String title;
            @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
        private LocalDateTime startAt;
            @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
        private LocalDateTime endAt;
        private Integer needMoney;
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
            public String getTitle() {
                return this.title;
            }
            public void setTitle(String title) {
                this.title = title;
            }
            public LocalDateTime getStartAt() {
                return this.startAt;
            }
            public void setStartAt(LocalDateTime startAt) {
                this.startAt = startAt;
            }
            public LocalDateTime getEndAt() {
                return this.endAt;
            }
            public void setEndAt(LocalDateTime endAt) {
                this.endAt = endAt;
            }
            public Integer getNeedMoney() {
                return this.needMoney;
            }
            public void setNeedMoney(Integer needMoney) {
                this.needMoney = needMoney;
            }
}