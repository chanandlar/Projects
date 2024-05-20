package com.example.DebuggApp.controllerpackage;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @GetMapping("/about")
    public String getAbout(){
        String s="Hello how are you?";
        s=s.toLowerCase();
        s=s.toUpperCase();
        return s;
    }
}
