package uz.jl.todosimple.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import uz.jl.todosimple.dto.TodoDto;
import uz.jl.todosimple.dto.UpdateDto;
import uz.jl.todosimple.services.TodoService;

import javax.validation.Valid;


@Controller
@RequestMapping("/todo/*")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @RequestMapping("create")
    public String createPage(Model model) {
        model.addAttribute("dto", new TodoDto());
        return "todo/create";
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.GET)
    public ModelAndView updatePage(ModelAndView modelAndView, @PathVariable(name = "id") Long id) {
        modelAndView.setViewName("todo/update");
        modelAndView.addObject("update", todoService.get(id));
        return modelAndView;
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(@ModelAttribute UpdateDto dto) {
        todoService.update(dto);
        return "redirect:/todo/list";
    }
    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public ModelAndView deletePage(ModelAndView modelAndView, @PathVariable(name = "id") Long id) {
        modelAndView.setViewName("todo/delete");
        modelAndView.addObject("delete", todoService.get(id));
        return modelAndView;
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public String delete(Long id) {
        todoService.delete(id);
        return "redirect:/todo/list";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute(name = "dto") TodoDto dto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "todo/create";
        }
        todoService.create(dto);
        return "redirect:/todo/list";
    }

    @RequestMapping("list")
    public String listPage(Model model) {
        model.addAttribute("todos", todoService.getAll());
        return "todo/all";
    }
}
