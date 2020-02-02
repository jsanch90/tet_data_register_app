package com.data.register.api.data_register_rest_api.security.config;

public class Constants {
    public static final String LOGIN_ENDPOINT = "/user/login";
    public static final String CREATE_USER_ENDPOINT = "/user/add";
    public static final String HEADER = "Authorization";
    public static final String PREFIX = "Bearer ";
    public static final String ISSUER_INFO = "localhost:8080";
    public static final String KEY = "1234";
    public static final long TOKEN_EXPIRATION_TIME = 600000;
}
