package com.example.GradingSystemNew.module.security;

import org.springframework.boot.web.server.Http2;
import org.springframework.stereotype.Component;
import com.auth0.jwt.JWT;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

import static com.auth0.jwt.algorithms.Algorithm.HMAC512;


@Component
public class JWTTokenProvider {
        public String generateToken(UserPrincipal userPrincipal, String IP){
            return JWT.create().withIssuer("").withAudience("")
                    .withIssuedAt(new Date()).withSubject(userPrincipal.getUsername())
                    .withClaim("IP", IP)
                    .withExpiresAt(new Date(System.currentTimeMillis() + 180_000_000))
                    .sign(HMAC512("secretKey".getBytes()));
        }

    public String getIpFromClient(HttpServletRequest request){
        return request.getRemoteAddr();
    }
}
