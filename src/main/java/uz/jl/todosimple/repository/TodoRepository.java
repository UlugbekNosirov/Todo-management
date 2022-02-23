package uz.jl.todosimple.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uz.jl.todosimple.entity.Todo;

import javax.transaction.Transactional;
import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    @Query("from Todo t where t.userId = :id")
    List<Todo> findAllByUserId(@Param("id") Long id);


    @Modifying
    @Transactional
    @Query("UPDATE Todo SET title = :title, description = :description where id=:id")
    void update(@Param("title") String title, @Param("description") String description, @Param("id") Long id);

}
