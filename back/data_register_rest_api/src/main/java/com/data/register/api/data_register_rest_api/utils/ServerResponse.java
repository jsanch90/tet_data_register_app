package com.data.register.api.data_register_rest_api.utils;

public class ServerResponse<T> {
    T response;
    boolean successful;

    public ServerResponse(T response, boolean successful) {
        this.response = response;
        this.successful = successful;
    }

    public ServerResponse(boolean successful) {
        this.successful = successful;
    }

    public T getResponse() {
        return response;
    }

    public void setResponse(T response) {
        this.response = response;
    }

    public boolean isSuccessful() {
        return successful;
    }

    public void setSuccessful(boolean successful) {
        this.successful = successful;
    }
}
