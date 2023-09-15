package com.springboot.firstwebapp.Hello.a5Login2;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    public boolean authenticate(String username,String password){
        return username.equalsIgnoreCase("Shoeb") && password.equalsIgnoreCase("test");
    }
}
