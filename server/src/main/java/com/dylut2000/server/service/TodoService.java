package com.dylut2000.server.service;

import com.dylut2000.server.model.dto.TodoDTO;
import com.dylut2000.server.model.dto.TodoRequestDTO;

import java.util.List;

public interface TodoService {

    public List<TodoDTO> getAllTodos();

    public List<TodoDTO> getAllTodosByUserId(String userId);

    public TodoDTO addNewTodo(TodoDTO todoDTO);

    public TodoDTO updateTodo(TodoRequestDTO todoDTO);

    public String deleteTodo();
}
