package com.springboot.firstwebapp.Hello.a7SpringSecurityandH2;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class TodoService {
    private static List<Todo> todos=new ArrayList<>();
    private static int todoscount=0;
    static {
        todos.add(new Todo(++todoscount,"Shoeb","Get AWS Certified", LocalDate.now().plusYears(1),false));
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

    public void deleteById(int id){
        Predicate<? super Todo> predicate = todo -> todo.getId()==id;
        todos.removeIf(predicate);
    }

    public Todo findById(int id) {
        Predicate<? super Todo> predicate = todo -> todo.getId()==id;
        Todo todo=todos.stream().filter(predicate).findFirst().get();
        return todo;
    }

    public void updateTodo(@Valid Todo todo) {
        deleteById(todo.getId());
        todos.add(todo);
    }
}
