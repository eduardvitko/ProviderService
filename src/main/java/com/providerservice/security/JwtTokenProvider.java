//package com.providerservice.security;
//
//import com.auth0.jwt.JWT;
//import com.auth0.jwt.algorithms.Algorithm;
//import org.springframework.beans.factory.annotation.Value;
//import static com.providerservice.security.SecurityConstant.*;
//
//import java.util.Date;
//
//public class JwtTokenProvider {
//    @Value("${jwt.secret}")
//    private String secret;
//
//    public String generateJWTToken(UserPrincipal userPrincipal) {
//        String claims[] = getClaimsFromUser(userPrincipal);
//        return JWT.create().withIssuer(GET_ARRAYS_LLC).withAudience(GET_ARRAYS_ADMINISTRATION)
//                .withIssuedAt(new Date()).withSubject(userPrincipal.getUsername()).withArrayClaim(AUTHORITIES,claims)
//                .withExpiresAt(new Date(System.currentTimeMillis()+EXPIRATION_TIME))
//                .sign(Algorithm.HMAC512(secret.getBytes()));
//    }
//
//    private String[] getClaimsFromUser(UserPrincipal userPrincipal){
//
//    }
//}
