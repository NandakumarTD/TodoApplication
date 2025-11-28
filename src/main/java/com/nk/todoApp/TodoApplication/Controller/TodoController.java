package com.nk.todoApp.TodoApplication.Controller;


import com.nk.todoApp.TodoApplication.Service.TodoService;
import com.nk.todoApp.TodoApplication.Utility.TodoDTO;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<TodoDTO> getAllTodoItems(){
        return service.getAllTodos();
    }

    @GetMapping("/getItemById/{id}")
    public List<TodoDTO> getItemByID(@PathVariable int id){
        return service.getTodobyId(id);

    }

    @GetMapping("/getItemByPriority/{priority}")
    public List<TodoDTO> getItemByPriority(@PathVariable String priority){
        return service.getTodoByPriority(priority);
    }

    @PostMapping("/addItem")
    public void addTodoItem(@RequestBody List<TodoDTO> items){
        TodoDTO vo = new TodoDTO();
        List<TodoDTO> li = new ArrayList<>();
//        vo.setId(items.getId());
        for(TodoDTO vo1 : items) {
            vo = new TodoDTO();
            vo.setTaskName(vo1.getTaskName());
            vo.setPriority(vo1.getPriority());
            vo.setTargetDate(vo1.getTargetDate());
            li.add(vo);
        }
        service.addTodoItem(li);
    }

    @PutMapping("/updateItem/{id}")
    public void updateTodoItemById(@PathVariable int id, @RequestBody TodoDTO item){
        TodoDTO vo = new TodoDTO();
            List<TodoDTO> li = new ArrayList<>();
        vo.setTaskName(item.getTaskName());
        vo.setPriority(item.getPriority());
        vo.setTargetDate(item.getTargetDate());
        li.add(vo);
        service.updateTodoById(id,li);
    }

    @DeleteMapping("/deleteItem/{id}")
    public void deleteItemById(@PathVariable int id){
        service.deleteTodoById(id);

    }
}
