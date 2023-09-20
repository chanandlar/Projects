package com.springboot.firstwebapp.Hello.a6Todo;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.List;

@Controller
@SessionAttributes("name")
public class TodoController {
    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @RequestMapping("list-todos")
    public String listAllTodos(ModelMap model){
        List<Todo> todos=todoService.findByUsername("Shoeb");
        model.addAttribute("todos",todos);
        return "ListTodos";
    }

    @RequestMapping("delete-todo")
    public String deleteTodo(@RequestParam int id){
        todoService.deletebyId(id);
        return "redirect:list-todos";
    }

    @RequestMapping("update-todo")
    public String updateTodo(@RequestParam int id){
        todoService.deletebyId(id);
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
        todoService.addTodo(username, todo.getDescription(),LocalDate.now().plusYears(1),false);
        return "redirect:list-todos";
    }
}
