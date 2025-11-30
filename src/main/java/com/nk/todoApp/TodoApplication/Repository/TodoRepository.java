package com.nk.todoApp.TodoApplication.Repository;

import com.nk.todoApp.TodoApplication.Utility.TodoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TodoRepository extends JpaRepository<TodoDTO, Long>{

    @Query(value = "select id,task_name,priority,target_date from tododto where priority = %:priority%", nativeQuery = true)
    List<TodoDTO> getTodoByPriority(String priority);

}
