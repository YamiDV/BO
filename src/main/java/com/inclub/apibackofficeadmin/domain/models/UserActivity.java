package com.inclub.apibackofficeadmin.domain.models;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Getter;
import lombok.Setter;

@Table("useractivity")
public class UserActivity {

    @Id
    private Long id;

    @Getter
    @Setter
    private String username;

    @Getter
    @Setter
    private String action;

    @Getter
    @Setter
    private LocalDateTime timestamp;

    public UserActivity() {
    }

    public UserActivity(String username, String action, LocalDateTime timestamp) {
        this.username = username;
        this.action = action;
        this.timestamp = timestamp;
    }
    
}
