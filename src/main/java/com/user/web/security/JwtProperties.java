package com.user.web.security;

public class JwtProperties {
    public static final String SECRET = "ALV";
    public static final int EXPIRATION_TIME = 5*60*60*1000;
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
}
