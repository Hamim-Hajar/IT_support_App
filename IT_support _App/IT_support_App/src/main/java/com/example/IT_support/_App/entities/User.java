package com.example.IT_support._App.entities;


import com.example.IT_support._App.enums.UserRole;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Entity
@DiscriminatorColumn(name = "user_type")

public abstract class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    @Column(unique = true, length = 100, nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(unique = true, length = 100, nullable = false)
    private String email;
    @Enumerated(EnumType.STRING)
   private UserRole role;

    private String speciality;

//    @Column(name = "user_type", insertable = false, updatable = false)
//    private String userType;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (role == null) {
            System.out.println("Role is not initialized.");
            return List.of();
        }
        return List.of(new SimpleGrantedAuthority("ROLE_" + role.name()));
    }

//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        DiscriminatorValue roleAnnotation = this.getClass().getAnnotation(DiscriminatorValue.class);
//        String roleName = roleAnnotation.value();
//        return List.of(new SimpleGrantedAuthority("ROLE_" + roleName));}

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

