package com.dylut2000.server.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    // GET ALL TODOS (ADMIN_ROLE)

    @GetMapping
    public String getAllTodos() {
        return "All todos";
    }


    // GET ALL TODOS BY USER_ID

    @GetMapping("/{userId}")
    public String getAllTodosByUserId() {
        return "All todos by user id";
    }


    // UPDATE TODO

    @PutMapping("/{todoId}")
    public String updateTodo() {
        return "Todo was updated successfully";
    }


    // DELETE TODO

    @DeleteMapping("/{todoId}")
    public String deleteTodo() {
        return "Todo was deleted successfully";
    }
}
