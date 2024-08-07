package com.example.IT_support._App.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.List;
@Entity
@DiscriminatorValue("userstandard")
public class UserStandar extends User{

}
