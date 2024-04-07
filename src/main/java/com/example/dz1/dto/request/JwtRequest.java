package com.example.dz1.dto.request;

import lombok.Data;

@Data
public class JwtRequest {
    private String username;
    private String password;
}