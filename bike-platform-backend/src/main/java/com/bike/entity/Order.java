package com.bike.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;

@TableName("`order`")
public class Order extends Model<Order> {

    private static final long serialVersionUID = 1L;

            @TableId(value = "id", type = IdType.AUTO)
        private Integer id;
        private Integer rentId;
        private Integer userId;
        private Integer status = 0;
            public Integer getId() {
                return this.id;
            }
            public void setId(Integer id) {
                this.id = id;
            }
            public Integer getRentId() {
                return this.rentId;
            }
            public void setRentId(Integer rentId) {
                this.rentId = rentId;
            }
            public Integer getUserId() {
                return this.userId;
            }
            public void setUserId(Integer userId) {
                this.userId = userId;
            }
            public Integer getStatus() {
                return this.status;
            }
            public void setStatus(Integer status) {
                this.status = status;
            }
}