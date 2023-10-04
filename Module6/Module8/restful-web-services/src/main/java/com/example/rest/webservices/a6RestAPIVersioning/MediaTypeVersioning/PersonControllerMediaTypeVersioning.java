package com.example.rest.webservices.a6RestAPIVersioning.MediaTypeVersioning;

import com.example.rest.webservices.a6RestAPIVersioning.URLVersioning.Name;
import com.example.rest.webservices.a6RestAPIVersioning.URLVersioning.PersonV1;
import com.example.rest.webservices.a6RestAPIVersioning.URLVersioning.PersonV2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonControllerMediaTypeVersioning {
    @GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v1+json")
    PersonV1 GetFirstVersionofPersonAcceptHeader(){
        return new PersonV1("Bob Charlie");
    }

    @GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v2+json")
    PersonV2 GetSecondVersionofPersonAcceptHeader(){
        return new PersonV2(new Name("Bob","Charlie"));
    }
}
