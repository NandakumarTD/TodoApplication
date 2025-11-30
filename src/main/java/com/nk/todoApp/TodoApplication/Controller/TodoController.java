package com.nk.todoApp.TodoApplication.Controller;


import com.nk.todoApp.TodoApplication.Service.TodoService;
import com.nk.todoApp.TodoApplication.Utility.TodoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/todo")
public class TodoController {


    @Autowired
    TodoService service;


    @GetMapping("/initial")
    public String initial(){
        return "Hi From Initial";
    }

    @GetMapping("/getAllItems")
    public ResponseEntity<List<TodoDTO>> getAllTodoItems(){
        return new ResponseEntity<List<TodoDTO>>(service.getAllTodos(), HttpStatus.OK);
    }

    @GetMapping("/getItemById/{id}")
    public ResponseEntity<TodoDTO> getItemByID(@PathVariable long id){
        return new ResponseEntity<TodoDTO>(service.getTodoById(id), HttpStatus.OK);
    }


    @GetMapping("/getItemByPriority/{priority}")
    public ResponseEntity<List<TodoDTO>> getItemByPriority(@PathVariable String priority){
        return new ResponseEntity<List<TodoDTO>>(service.getTodoByPriority(priority), HttpStatus.OK);
    }


    @PostMapping("/addItem")
    public ResponseEntity<TodoDTO> addTodoItem(@RequestBody TodoDTO items){
        TodoDTO vo = new TodoDTO();
        service.saveTodoData(items);
        return new ResponseEntity<TodoDTO>(items,HttpStatus.CREATED);
    }

    @PutMapping("/updateItem")
    public ResponseEntity<TodoDTO> updateTodoItemById(@RequestBody TodoDTO item){
        service.updateTodo(item);
        return new ResponseEntity<TodoDTO>(item,HttpStatus.OK);
    }


    @DeleteMapping("/deleteItem/{id}")
    public ResponseEntity<String> deleteItemById(@PathVariable long id){
        String status = service.deleteTodo(id);
        if(status.equalsIgnoreCase("Deleted")){
            return new ResponseEntity<String>("Todo Deleted",HttpStatus.OK);
        }
        else{
            return new ResponseEntity<String>("ID Not Found",HttpStatus.NOT_FOUND);
        }
    }

}
