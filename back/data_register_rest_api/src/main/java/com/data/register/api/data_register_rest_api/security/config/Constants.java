package com.data.register.api.data_register_rest_api.security.config;

public class Constants {
    public static final String LOGIN_ENDPOINT = "login";
    public static final String HEADER_AUTHORIZACION_KEY = "Authorization";
    public static final String TOKEN_BEARER_PREFIX = "Bearer ";
    public static final String ISSUER_INFO = "localhost:8080";
    public static final String SUPER_SECRET_KEY = "1234";
    public static final long TOKEN_EXPIRATION_TIME = 864_000_000;
}
