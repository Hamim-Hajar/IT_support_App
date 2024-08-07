package com.example.IT_support._App.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.List;

@Entity
@DiscriminatorValue("technicien")
public class Technicien extends User{



@OneToMany
    private List<Technicien> techniciens;
}
