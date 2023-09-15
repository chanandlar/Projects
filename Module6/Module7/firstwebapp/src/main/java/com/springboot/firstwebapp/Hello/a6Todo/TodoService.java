package com.springboot.firstwebapp.Hello.a6Todo;

import java.time.LocalDate;
import java.util.List;

public class TodoService {
    private static List<a6Todo> todos;
    static {
        todos.add(new a6Todo(1,"Shoeb","Learn AWS", LocalDate.now().plusYears(1),false));
        todos.add(new a6Todo(2,"Shoeb","Learn Devops",LocalDate.now().plusYears(2),false));
        todos.add(new a6Todo(3,"Shoeb","Full Stack Development",LocalDate.now().plusYears(3),false));
    }

    public List<a6Todo> findByUsername(String username){
        return todos;
    }
}
