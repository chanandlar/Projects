package com.example.rest.webservices.a6RestAPIVersioning.RequestParameterVersioning;

import com.example.rest.webservices.a6RestAPIVersioning.URLVersioning.Name;
import com.example.rest.webservices.a6RestAPIVersioning.URLVersioning.PersonV1;
import com.example.rest.webservices.a6RestAPIVersioning.URLVersioning.PersonV2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
    @GetMapping(path="/person", params="version=1")
    public PersonV1 getFirstVersionofPersonRequestParameter(){
        return new PersonV1("Bob Charlie");
    }

    @GetMapping(path="/person", params="version=2")
    public PersonV2 getSecondVersionofPersonRequestParameter(){
        return new PersonV2(new Name("Bob","Charlie"));
    }
}
