package com.example.keycloakadmin.model;

import lombok.*;
import org.keycloak.representations.JsonWebToken;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String id;
    private String userName;
    private String email;
    private String firstName;
    private String lastName;


}
