package com.example.rest.webservices.a9JPAConnection;


import com.example.rest.webservices.a4RestAPI.ExceptionHandling.UserNotFoundException;
import com.example.rest.webservices.a4RestAPI.User;
import com.example.rest.webservices.a4RestAPI.UserDAOService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class UserJPAResource {
    private UserRepository repository;
    private PostRepository postRepository;

    public UserJPAResource(UserRepository repository,PostRepository postRepository) {
        this.repository=repository;
        this.postRepository=postRepository;
    }

    @GetMapping(path = "/jpa/users")
    public List<com.example.rest.webservices.a9JPAConnection.User> retrieveAllUsers(){
        return repository.findAll();
    }

    @GetMapping(path = "/jpa/users/{id}")
    public Optional<com.example.rest.webservices.a9JPAConnection.User> retrieveUser(@PathVariable int id){
        Optional<com.example.rest.webservices.a9JPAConnection.User> user=repository.findById(id);
        if(user.isEmpty()){
            throw new UserNotFoundException("id:"+id);
        }

        return user;
    }

    @DeleteMapping(path = "/jpa/users/{id}")
    public void deleteUser(@PathVariable int id){
        repository.deleteById(id);
    }

    @GetMapping(path = "/jpa/users/{id}/posts")
    public List<Post> retrievePostsForUser(@PathVariable int id){

        Optional<com.example.rest.webservices.a9JPAConnection.User> user=repository.findById(id);
        if(user.isEmpty()){
            throw new UserNotFoundException("id:"+id);
        }
        return user.get().getPosts();
    }

    @PostMapping(path = "/jpa/users/{id}/posts")
    public void createPostsForUser(@PathVariable int id, @Valid @RequestBody Post post){

        Optional<com.example.rest.webservices.a9JPAConnection.User> user=repository.findById(id);
        if(user.isEmpty()){
            throw new UserNotFoundException("id:"+id);
        }
        post.setUser(user.get());
        postRepository.save(post);

    }

    @PostMapping(path = "/jpa/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody com.example.rest.webservices.a9JPAConnection.User user){
        com.example.rest.webservices.a9JPAConnection.User savedUser=repository.save(user);

        URI location= ServletUriComponentsBuilder.
                fromCurrentRequest().path("/{id}").
                buildAndExpand(savedUser.getId()).
                toUri();
        return ResponseEntity.created(location).build();
    }


}
