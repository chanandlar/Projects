package com.example.rest.webservices.a3HelloWorldPathVariable;

import com.example.rest.webservices.a2HelloWorldBean.HelloWorldBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloWorldPathVariableController {
    @GetMapping(path = "/hello-world/path-variable/{name}")
    public HelloWorldBean helloworldpathvariable(@PathVariable String name){
        return new HelloWorldBean (String.format ("Hello World %s", name));
    }
}
