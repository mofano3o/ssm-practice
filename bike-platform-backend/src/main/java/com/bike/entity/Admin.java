package com.bike.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;

public class Admin extends Model<Admin> {

    private static final long serialVersionUID = 1L;

            @TableId(value = "id", type = IdType.AUTO)
        private Integer id;
        private String name;
        private String password;
            public Integer getId() {
                return this.id;
            }
            public void setId(Integer id) {
                this.id = id;
            }
            public String getName() {
                return this.name;
            }
            public void setName(String name) {
                this.name = name;
            }
            public String getPassword() {
                return this.password;
            }
            public void setPassword(String password) {
                this.password = password;
            }
}