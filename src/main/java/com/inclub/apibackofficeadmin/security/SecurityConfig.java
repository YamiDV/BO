package com.inclub.apibackofficeadmin.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@EnableWebFluxSecurity
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        http
            .csrf().disable()  
            .authorizeExchange()
            .pathMatchers("/login").permitAll()
            .pathMatchers("/admin/**").hasAuthority("ROLE_ADMIN") 
            // .pathMatchers("/users/**").hasAuthority("Nuevos Rangos") 
            // .pathMatchers("/rols/**").hasAuthority("Pagos Cuotas")
            .anyExchange().authenticated()
            .and().addFilterAt(jwtAuthenticationWebFilter(), SecurityWebFiltersOrder.AUTHENTICATION);

        return http.build();
    }

    @Bean
    public JwtAuthenticationWebFilter jwtAuthenticationWebFilter() {
        return new JwtAuthenticationWebFilter();
    }
}