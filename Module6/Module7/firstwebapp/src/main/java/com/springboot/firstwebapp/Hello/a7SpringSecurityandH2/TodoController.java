package com.springboot.firstwebapp.Hello.a7SpringSecurityandH2;


import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.List;

//@Controller
@SessionAttributes("name")
public class TodoController {
    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @RequestMapping("list-todos")
    public String listAllTodos(ModelMap model){
        String username=(String) model.get("name");
        List<Todo> todos=todoService.findByUsername(username);
        model.addAttribute("todos",todos);
        return "ListTodos";
    }

    @RequestMapping("delete-todo")
    public String deleteTodo(@RequestParam int id){
        todoService.deleteById(id);
        return "redirect:list-todos";
    }

    @RequestMapping(value = "update-todo",method = RequestMethod.GET)
    public String ShowupdateTodopage(@RequestParam int id,ModelMap model){
        Todo todo=todoService.findById(id);
        model.addAttribute("todo",todo);
        return "Todo";
    }

    @RequestMapping(value = "update-todo",method = RequestMethod.POST)
    public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result){
        if(result.hasErrors()){
            return "Todo";
        }
        String username=(String) model.get("name");
        todo.setUsername(username);
        todoService.updateTodo(todo);
        return "redirect:list-todos";
    }

    @RequestMapping(value = "add-todo",method = RequestMethod.GET)
    public String showNewTodoPage(ModelMap model){
        Todo todo=new Todo(0,(String)model.get("name"),"",LocalDate.now().plusYears(1),false);
        model.put("todo",todo);
        return "Todo";
    }

    @RequestMapping(value = "add-todo",method = RequestMethod.POST)
    public String addNewTodo(ModelMap model, @Valid Todo todo, BindingResult result){
        if(result.hasErrors()){
            return "Todo";
        }
        String username=(String) model.get("name");
        todoService.addTodo(username, todo.getDescription(),todo.getTarget_date(),false);
        return "redirect:list-todos";
    }
}
