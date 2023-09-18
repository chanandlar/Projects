package com.springboot.firstwebapp.Hello.a6Todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {
    private static List<Todo> todos=new ArrayList<>();
    private static int todoscount=0;
    static {
        todos.add(new Todo(++todoscount,"Shoeb","Learn AWS", LocalDate.now().plusYears(1),false));
        todos.add(new Todo(++todoscount,"Shoeb","Learn Devops",LocalDate.now().plusYears(2),false));
        todos.add(new Todo(++todoscount,"Shoeb","Full Stack Development",LocalDate.now().plusYears(3),false));
    }

    public List<Todo> findByUsername(String username){
        return todos;
    }

    public void addTodo(String username,String Description,LocalDate TargetDate,boolean isDone){
        Todo todo=new Todo(++todoscount,username,Description,TargetDate,isDone);
        todos.add(todo);
    }
}
