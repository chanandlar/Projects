package com.springboot.firstwebapp.Hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class a5LoginController2 {
    @RequestMapping("login1")
    public String gotoLoginPage() {
        return "login1";
    }
}
