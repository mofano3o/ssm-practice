package com.bike.request;

public class ListMessageRequest extends PageRequest{
    private int userId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
