package com.example.demo.model.user;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@Data
@NoArgsConstructor
public class Role implements GrantedAuthority {

    private Long id;

    private String name;

    @Override
    public String getAuthority() {
        return "ROLE_" + name;
    }
}
