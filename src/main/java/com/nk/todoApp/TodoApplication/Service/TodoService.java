package com.nk.todoApp.TodoApplication.Service;


import com.nk.todoApp.TodoApplication.Repository.TodoRepository;
import com.nk.todoApp.TodoApplication.Utility.TodoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class TodoService {

    @Autowired
    TodoRepository repository;


    public TodoService() {
    }

    public List<TodoDTO> getAllTodos() {
        return repository.findAll();
    }

    public TodoDTO getTodoById(long id) {
        return repository.findById(id).orElse(null);
    }

    public List<TodoDTO> getTodoByPriority(String priority){
        return repository.getTodoByPriority(priority);
    }


    public TodoDTO saveTodoData(TodoDTO dTo) {
        repository.save(dTo);
        return dTo;
    }

    public TodoDTO updateTodo(TodoDTO dto){
       repository.save(dto);
        return dto;
    }

    public String deleteTodo(Long id){
        TodoDTO item = getTodoById(id);
        if(item!=null){
            repository.deleteById(id);
            return "Deleted";
        }
        else{
            throw new RuntimeException("Id Not found");
        }
    }


}



