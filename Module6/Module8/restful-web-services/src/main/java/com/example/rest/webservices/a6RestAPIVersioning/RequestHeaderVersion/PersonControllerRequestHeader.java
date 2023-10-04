package com.example.rest.webservices.a6RestAPIVersioning.RequestHeaderVersion;

import com.example.rest.webservices.a6RestAPIVersioning.URLVersioning.Name;
import com.example.rest.webservices.a6RestAPIVersioning.URLVersioning.PersonV1;
import com.example.rest.webservices.a6RestAPIVersioning.URLVersioning.PersonV2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonControllerRequestHeader {

    @GetMapping(path = "/person/header", headers = "X-API-VERSION=1")
    public PersonV1 getFirstVersionofPersonRequestHeader(){
        return new PersonV1("Bob Charlie");
    }

    @GetMapping(path = "/person/header", headers = "X-API-VERSION=2")
    public PersonV2 getSecondVersionofPersonRequestHeader(){
        return new PersonV2(new Name("Bob","Charlie"));
    }
}
