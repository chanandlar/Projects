package com.example.rest.webservices.a8CustomizingJSONResponse.JSONResponse;


import com.example.rest.webservices.a4RestAPI.ExceptionHandling.UserNotFoundException;
import com.example.rest.webservices.a7RestAPIHateaos.User;
import com.example.rest.webservices.a7RestAPIHateaos.UserDAOServiceHateoas;
import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserResourceJSONResponse {
    private UserDAOServiceHateoas service;

    public UserResourceJSONResponse(UserDAOServiceHateoas userDAOServiceHateoas) {
        this.service = userDAOServiceHateoas;
    }

    @GetMapping(path = "jsonresponse/users")
    public List<com.example.rest.webservices.a7RestAPIHateaos.User> retrieveAllUsers(){
        return service.findAll();
    }

    @GetMapping(path = "jsonresponse/users/{id}")
    public EntityModel<com.example.rest.webservices.a7RestAPIHateaos.User> retrieveUser(@PathVariable int id){
        com.example.rest.webservices.a7RestAPIHateaos.User user=service.findById(id);
        if(user==null){
            throw new UserNotFoundException("id:"+id);
        }
        EntityModel<com.example.rest.webservices.a7RestAPIHateaos.User> entityModel=EntityModel.of(user);
        //WebMvcLinkBuilder link= linkTo(methodOn(this.getClass()).retrieveAllUsers());
        //entityModel.add(link.withRel("all-users"));
        return entityModel;
    }

    @DeleteMapping(path = "jsonresponse/users/{id}")
    public void deleteUser(@PathVariable int id){
        service.deleteById(id);
    }

    @PostMapping(path = "jsonresponse/users")
    public ResponseEntity<com.example.rest.webservices.a7RestAPIHateaos.User> createUser(@Valid @RequestBody com.example.rest.webservices.a7RestAPIHateaos.User user){
        User savedUser=service.save(user);

        URI location= ServletUriComponentsBuilder.
                fromCurrentRequest().path("/{id}").
                buildAndExpand(savedUser.getId()).
                toUri();


        return ResponseEntity.created(location).build();
    }
}
