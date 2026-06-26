package com.example.milktea_backend.dto;

public class CheckResponse {
    private boolean exists;

    public CheckResponse() {}

    public CheckResponse(boolean exists) {
        this.exists = exists;
    }

    public boolean isExists() {
        return exists;
    }

    public void setExists(boolean exists) {
        this.exists = exists;
    }
}