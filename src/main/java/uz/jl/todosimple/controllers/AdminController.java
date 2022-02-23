package uz.jl.todosimple.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uz.jl.todosimple.services.TodoService;

@Controller

@RequestMapping("/auth/*")
@PreAuthorize("hasRole('ADMIN')")

public class AdminController {
    private final TodoService todoService;

    public AdminController(TodoService todoService) {
        this.todoService = todoService;
    }

    @RequestMapping(value = "adminTodos", method = RequestMethod.GET)
    public String adminPage() {
        return "auth/adminTodos";
    }
    @RequestMapping("alltodos")
    public String listPage(Model model) {
        model.addAttribute("adminalltodos", todoService.getAllforAdmin());
        return "auth/alltodos";
    }
    @RequestMapping("mytodos")
    public String mytodosPage(Model model) {
        model.addAttribute("admintodos", todoService.getAll());
        return "auth/mytodos";
    }


}
