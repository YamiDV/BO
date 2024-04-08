package com.inclub.apibackofficeadmin.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;

import com.inclub.apibackofficeadmin.aplication.services.Interface.ItemMenuService;
import com.inclub.apibackofficeadmin.domain.models.UserLogin;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class JwtAuthenticationWebFilter implements WebFilter {

    // Constructor, servicios y métodos adicionales aquí

    @Value("${springbootwebfluxjjwt.jjwt.secret}")
    private String secret;

    @Autowired
    private ItemMenuService itemMenuService;



    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        String token = exchange.getRequest().getHeaders().getFirst("Authorization");
        if (token != null && token.startsWith("Bearer ")) {
            token = token.substring(7); // Eliminar el prefijo "Bearer "
            try {
                Claims claims = Jwts.parser()
                        .setSigningKey(secret.getBytes())
                        .parseClaimsJws(token)
                        .getBody();

                Integer userId = (Integer) claims.get("id"); // Suponiendo que el ID está en el subject del token

                //Recordar que el SecurityContextHolder carga en el Principal solo Id de usuario como el Username
                UserLogin userDetails = new UserLogin(userId.toString(), null, null);

                Flux<String> authorityNames = itemMenuService.findNamesByUserId(userId);
                                                 // asumiendo que ItemMenu tiene un método getName
                                                 

                Flux<GrantedAuthority> authorities = authorityNames.map(SimpleGrantedAuthority::new);

                return authorities.collectList().flatMap(authorityList -> {
                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, authorityList);
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                    return chain.filter(exchange).contextWrite(ReactiveSecurityContextHolder.withAuthentication(authentication));
                });

            } catch (Exception e) {
                e.printStackTrace();
                return Mono.error(new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Token no válido"));
            }
        }

        return chain.filter(exchange);

    }

}