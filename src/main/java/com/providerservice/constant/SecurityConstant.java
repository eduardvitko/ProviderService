package com.providerservice.constant;

public class SecurityConstant {

    String SECRET = "SecretKeyToGenJWTs";
    String TOKEN_PREFIX = "Bearer ";
    String HEADER_STRING = "Authorization";
    String SIGN_UP_URL = "/customer-service/customer/registration";
    long EXPIRATION_TIME = 864_000_000; // 10 days
}
