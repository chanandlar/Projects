package com.example.rest.webservices.a7RestAPIHateaos;



import com.example.rest.webservices.a4RestAPI.ExceptionHandling.UserNotFoundException;
import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.reactive.WebFluxLinkBuilder.linkTo;
import static org.springframework.hateoas.server.reactive.WebFluxLinkBuilder.methodOn;

@RestController
public class UserResourceHateoas {
    private UserDAOServiceHateoas service;

    public UserResourceHateoas(UserDAOServiceHateoas userDAOServiceHateoas) {
        this.service = userDAOServiceHateoas;
    }

    @GetMapping(path = "hateoas/users")
    public List<User> retrieveAllUsers(){
        return service.findAll();
    }

    @GetMapping(path = "hateoas/users/{id}")
    public EntityModel<User> retrieveUser(@PathVariable int id){
        User user=service.findById(id);
        if(user==null){
            throw new UserNotFoundException("id:"+id);
        }
        EntityModel<User> entityModel=EntityModel.of(user);
        //WebMvcLinkBuilder link= linkTo(methodOn(this.getClass()).retrieveAllUsers());
        //entityModel.add(link.withRel("all-users"));
        return entityModel;
    }

    @DeleteMapping(path = "hateoas/users/{id}")
    public void deleteUser(@PathVariable int id){
        service.deleteById(id);
    }

    @PostMapping(path = "hateoas/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
        User savedUser=service.save(user);

        URI location= ServletUriComponentsBuilder.
                fromCurrentRequest().path("/{id}").
                buildAndExpand(savedUser.getId()).
                toUri();


        return ResponseEntity.created(location).build();
    }
}
