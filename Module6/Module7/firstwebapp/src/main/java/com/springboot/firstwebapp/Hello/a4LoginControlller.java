package com.springboot.firstwebapp.Hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class a4LoginControlller {
    @RequestMapping("login")
    public String gotoLoginPage(){
        return "login";
    }
}
