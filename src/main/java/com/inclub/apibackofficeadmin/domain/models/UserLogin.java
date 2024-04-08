package com.inclub.apibackofficeadmin.domain.models;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserLogin implements UserDetails {

    private String username;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    public UserLogin(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // Puedes modificar esto según la lógica de tu aplicación
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Puedes modificar esto según la lógica de tu aplicación
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Puedes modificar esto según la lógica de tu aplicación
    }

    @Override
    public boolean isEnabled() {
        return true; // Puedes modificar esto según la lógica de tu aplicación
    }
    
}
