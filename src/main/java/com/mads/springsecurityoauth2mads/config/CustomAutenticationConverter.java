package com.mads.springsecurityoauth2mads.config;

import lombok.AllArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class CustomAutenticationConverter implements Converter<Jwt, AbstractAuthenticationToken> {

    List<GrantedAuthority> authorities;
    @Override
    public AbstractAuthenticationToken convert(Jwt jwt) {
        System.out.println("hola");
        List<String> roles = (List<String>) jwt.getClaimAsMap("realm_access").get("roles");
        for (String rol : roles){
            authorities.add(new SimpleGrantedAuthority(rol));
        }


        JwtAuthenticationToken token = new JwtAuthenticationToken(jwt,authorities);
        return token;
    }
}
