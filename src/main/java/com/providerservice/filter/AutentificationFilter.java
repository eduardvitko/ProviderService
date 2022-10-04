package com.providerservice.filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.providerservice.model.CustomerEntity;
import com.providerservice.model.Role;
import com.providerservice.serviceImplements.CustomerServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.stream.Collectors;

@Slf4j
public class AutentificationFilter extends UsernamePasswordAuthenticationFilter {
    private AuthenticationManager authenticationManager;

    public AutentificationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
        //this.setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/login", "POST"));
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req,
                                                HttpServletResponse res) throws AuthenticationException {
        String phone = req.getParameter("username");
        String password = req.getParameter("password");
        log.info("phone is : {}", phone);
        log.info("password is : {}", password);
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(phone, password);
        return authenticationManager.authenticate(authenticationToken);
    }


    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authentication) throws IOException, ServletException {
        User user = (User) authentication.getPrincipal();
        super.successfulAuthentication(request, response, chain, authentication);
        Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
        String access_token = JWT.create()
                .withIssuer(user.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis()*10*60*1000))
                .withIssuer(request.getRequestURL().toString())
                .withClaim("roles",user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                .sign(algorithm);
        String refresh_token = JWT.create()
                .withIssuer(user.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis()*30*60*1000))
                .withIssuer(request.getRequestURL().toString())
                .sign(algorithm);
        response.setHeader("access_token",access_token);
        response.setHeader("refresh_token",refresh_token);
    }
}
