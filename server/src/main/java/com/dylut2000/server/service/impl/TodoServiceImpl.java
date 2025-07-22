package com.dylut2000.server.service.impl;

import com.dylut2000.server.model.dto.TodoDTO;
import com.dylut2000.server.model.dto.TodoRequestDTO;
import com.dylut2000.server.repository.TodoRepository;
import com.dylut2000.server.service.TodoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;


    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }


    @Override
    public List<TodoDTO> getAllTodos() {
        return List.of();
    }



    @Override
    public List<TodoDTO> getAllTodosByUserId(String userId) {
        UUID uuid = UUID.fromString(userId);

        return List.of();
    }



    @Override
    public TodoDTO addNewTodo(TodoDTO todoDTO) {
        return null;
    }



    @Override
    public TodoDTO updateTodo(TodoRequestDTO todoDTO) {
        return null;
    }




    @Override
    public String deleteTodo() {
        return "";
    }

}
