package com.springboot.firstwebapp.Hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class a5LoginController2 {
    @RequestMapping(value="login1",method = RequestMethod.GET)
    public String gotoLoginPage() {
        return "login1";
    }

    @RequestMapping(value="login1",method = RequestMethod.POST)
    public String gotoWelcomePage(@RequestParam String name,@RequestParam String password,ModelMap model) {
        model.put("name",name);
        model.put("password",password);
        return "welcome";
    }
}
