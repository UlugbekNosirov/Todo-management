package uz.jl.todosimple.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.jl.todosimple.entity.Todo;


import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TodoDto {

    private Long id;
    @Size(min = 10, max = 30,message = "min size for title must be between {min} and {max}")
    private String title;
    private String description;
    private boolean completed;

    public TodoDto(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public TodoDto(Todo todo) {
        this.id = todo.getId();
        this.title = todo.getTitle();
        this.description = todo.getDescription();
        this.completed = todo.isCompleted();
    }
}
