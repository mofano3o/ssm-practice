package com.bike.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;

@TableName("`user`")
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

            @TableId(value = "id", type = IdType.AUTO)
        private Integer id;
        private String name;
        private String password;
        private String imgUrl;
        private int status = 0;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

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
            public String getImgUrl() {
                return this.imgUrl;
            }
            public void setImgUrl(String imgUrl) {
                this.imgUrl = imgUrl;
            }
}