package com.nk.todoApp.TodoApplication.Service;


import com.nk.todoApp.TodoApplication.Utility.TodoDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class TodoService {


    List<TodoDTO> todoList = new ArrayList<>();
    public int id = 1;

    public TodoService() {
    }

    public List<TodoDTO> getAllTodos(){
        return todoList;
    }

    public List<TodoDTO> getTodobyId(int id){
        return todoList.stream().filter(todoDTO -> todoDTO.getId() == id).collect(Collectors.toList());
    }

    public List<TodoDTO> getTodoByPriority(String priority){
        return todoList.stream().filter(todoDTO -> todoDTO.getPriority().equalsIgnoreCase(priority)).collect(Collectors.toList());
    }

    public String addTodoItem(List<TodoDTO> list){
        TodoDTO dTo = new TodoDTO();
        if(list.isEmpty()){
            return "No data to save";
        }
        else {
            for (TodoDTO vo : list) {
                dTo = new TodoDTO();
                dTo.setId(id++);
                dTo.setTaskName(vo.getTaskName());
                dTo.setPriority(vo.getPriority());
                dTo.setTargetDate(vo.getTargetDate());
                todoList.add(dTo);
            }
            return "Todo Added";
        }

    }


    public String updateTodoById(int id,List<TodoDTO> updatelist){
        TodoDTO dTo = new TodoDTO();
        if(updatelist.isEmpty()){
            return "No Todo Updated";
        }
        else {
            System.out.println("Inside update");
            for (TodoDTO vo : updatelist) {
                dTo = new TodoDTO();
                dTo.setTaskName(vo.getTaskName());
                dTo.setPriority(vo.getPriority());
                dTo.setTargetDate(vo.getTargetDate());
                todoList.set(id, dTo);
            }
            return "Todo Updated";
        }


    }


    public String deleteTodoById(int id){
        todoList.remove(id);
        return "Todo Removed";
    }



}
