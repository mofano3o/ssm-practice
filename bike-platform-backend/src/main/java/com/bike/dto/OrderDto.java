package com.bike.dto;

import com.baomidou.mybatisplus.extension.activerecord.Model;

public class OrderDto extends Model<OrderDto> {

    private Integer id;
    private Integer userId;
    private String title;
    private String startAt;
    private String endAt;
    private String type;
    private String status;
    private String user;
    private String rentUser;
    private String orderUser;
    private Integer rentUserId;
    private Integer orderUserId;

    public Integer getRentUserId() {
        return rentUserId;
    }

    public void setRentUserId(Integer rentUserId) {
        this.rentUserId = rentUserId;
    }

    public Integer getOrderUserId() {
        return orderUserId;
    }

    public void setOrderUserId(Integer orderUserId) {
        this.orderUserId = orderUserId;
    }

    public String getRentUser() {
        return rentUser;
    }

    public void setRentUser(String rentUser) {
        this.rentUser = rentUser;
    }

    public String getOrderUser() {
        return orderUser;
    }

    public void setOrderUser(String orderUser) {
        this.orderUser = orderUser;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStartAt() {
        return startAt;
    }

    public void setStartAt(String startAt) {
        this.startAt = startAt;
    }

    public String getEndAt() {
        return endAt;
    }

    public void setEndAt(String endAt) {
        this.endAt = endAt;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}