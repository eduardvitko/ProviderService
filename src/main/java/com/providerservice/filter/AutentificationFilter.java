package com.providerservice.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
        String userName = req.getParameter("username");
        String password = req.getParameter("password");
        log.info("userName is : {}", userName);
        log.info("password is : {}", password);
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userName, password);
        return authenticationManager.authenticate(authenticationToken);
    }


    @Override
    protected void successfulAuthentication(HttpServletRequest req,
                                            HttpServletResponse res,
                                            FilterChain chain,
                                            Authentication auth) throws IOException, ServletException {
//        if (auth.getPrincipal() != null) {
//            org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) auth.getPrincipal();
//            String login = user.getUsername();
//            if (login != null && login.length() > 0) {
//
//                Claims claims = Jwts.claims().setSubject(login);
//
//                List<String> roles = new ArrayList<>();
//                user.getAuthorities().stream().forEach(authority -> roles.add(authority.getAuthority()));
//                claims.put("roles", roles);
//
//                String token = Jwts.builder()
//                        .setClaims(claims)
//                        .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
//                        .signWith(SignatureAlgorithm.HS512, SECRET)
//                        .compact();
//                res.addHeader(HEADER_STRING, TOKEN_PREFIX + token);
//                System.out.println(token);
//            }
//
//        }
    }
}
