package com.example.demo.entiteas;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqRes {
    private int statusCode;
    private String name;
    private String password;
    private String role;
    private String message;
    private String error;
    private String expirationTime;
    private String refreshToken;
    private String token;
    private MyUser user;
    private List<MyUser> users;

}
