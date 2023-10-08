package com.example.rest.webservices.a10MySQLConnection;


import com.example.rest.webservices.a4RestAPI.ExceptionHandling.UserNotFoundException;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class UserMySQLResource {
    private UserMySQLRepository repository;

    public UserMySQLResource(UserMySQLRepository repository) {
        this.repository=repository;
    }

    @GetMapping(path = "/mysql/users")
    public List<User> retrieveAllUsers(){
        return repository.findAll();
    }

    @GetMapping(path = "/mysql/users/{id}")
    public Optional<User> retrieveUser(@PathVariable int id){
        Optional<User> user=repository.findById(id);
        if(user.isEmpty()){
            throw new UserNotFoundException("id:"+id);
        }

        return user;
    }

    @DeleteMapping(path = "/mysql/users/{id}")
    public void deleteUser(@PathVariable int id){
        repository.deleteById(id);
    }





    @PostMapping(path = "/mysql/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
        User savedUser=repository.save(user);

        URI location= ServletUriComponentsBuilder.
                fromCurrentRequest().path("/{id}").
                buildAndExpand(savedUser.getId()).
                toUri();
        return ResponseEntity.created(location).build();
    }


}
