package com.springboot.firstwebapp.Hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class a3BasicHellowithJSP {
    @RequestMapping("say-hello-jsp")
    public String sayHellowithjsp(){
        return "sayHello";
    }
}
