package uz.jl.todosimple.services;


import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import uz.jl.todosimple.configs.security.UserDetails;
import uz.jl.todosimple.dto.TodoDto;
import uz.jl.todosimple.dto.UpdateDto;
import uz.jl.todosimple.entity.Todo;
import uz.jl.todosimple.repository.TodoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<TodoDto> getAll() {
        Long userId = ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
        List<Todo> todoList = todoRepository.findAllByUserId(userId);
        return todoList.stream().map(TodoDto::new).toList();
    }
    public List<TodoDto> getAllforAdmin() {
        List<Todo> todoList = todoRepository.findAll();
        return todoList.stream().map(TodoDto::new).toList();
    }

    public Optional<TodoDto> get(Long id) {
        Optional<TodoDto> todo = getAll().stream().filter(todoDto -> todoDto.getId().equals(id)).findFirst();
        return todo;
    }

    public void create(TodoDto dto) {
        Todo todo = new Todo();
        todo.setTitle(dto.getTitle());
        todo.setDescription(dto.getDescription());
        Long userId = ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
        todo.setUserId(userId);
        todoRepository.save(todo);
    }

    public void update(UpdateDto dto) {
        //  Long userId = ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
        todoRepository.update(dto.getTitle(), dto.getDescription(), dto.getId());
    }
    public void delete(Long id) {
        //  Long userId = ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
        todoRepository.deleteById(id);
    }
}
