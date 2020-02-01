package com.data.register.api.data_register_rest_api.utils;

public class ServerResponse<T> {
    T response;

    public ServerResponse(T response) {
        this.response = response;
    }

    public T getResponse() {
        return response;
    }

    public void setResponse(T response) {
        this.response = response;
    }
}
