package com.user.web.security;

public class JwtPropieties {
    public static final String SECRET = "ALV";
    public static final int EXPIRATION_TIME = 5*60*60;
    public static final String TOKEN_PREFIX = "severetrip";
    public static final String HEADER_STRING = "Authorization";
}
