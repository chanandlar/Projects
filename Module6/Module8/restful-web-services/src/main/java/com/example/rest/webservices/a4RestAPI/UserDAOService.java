package com.example.rest.webservices.a4RestAPI;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDAOService {
    private static List<User> users=new ArrayList<>();
    private static int count=0;
    static {
        users.add(new User(++count,"Adam", LocalDate.now().minusYears(30)));
        users.add(new User(++count,"Eve",LocalDate.now().minusYears(25)));
        users.add(new User(++count,"Jim",LocalDate.now().minusYears(20)));
    }
    public List<User> findAll(){
        return users;
    }

    public User save(User user){
        user.setId(++count);
        users.add(user);
        return user;
    }

    public User findById(int id) {
        Predicate<? super User> predicate = user -> user.getId()==id;
        return users.stream().filter(predicate).findFirst().orElse(null);
    }

    public void deleteById(int id) {
        Predicate<? super User> predicate = user -> user.getId()==id;
        users.removeIf(predicate);
    }



}
