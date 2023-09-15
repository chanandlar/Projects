package com.springboot.firstwebapp.Hello.a3HelloWithJSP;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BasicHellowithJSP {
    @RequestMapping("say-hello-jsp")
    public String sayHellowithjsp(){
        return "sayHello";
    }
}
