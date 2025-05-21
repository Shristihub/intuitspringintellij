package com.bookapp.model;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ApiUserDto {
    private Integer userId;
    private String username;
    private String password;
    @ElementCollection
    @CollectionTable(name="apiuser_roles")
    private Set<String> roles;
}
