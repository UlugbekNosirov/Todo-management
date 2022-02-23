package uz.jl.todosimple.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import uz.jl.todosimple.services.TodoService;

@Controller
public class HomeController {

    private final TodoService todoService;

    @Autowired
    public HomeController(TodoService todoService) {
        this.todoService = todoService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String homePage(Model model) {
        return "home";
    }

    @PreAuthorize("isAuthenticated()")
    @ResponseBody
    @RequestMapping("/secure")
    private String securedPage() {
        return "<h1>Secured Page </h1>";
    }
}
