package com.dylut2000.server.controller;

import com.dylut2000.server.model.dto.TodoDTO;
import com.dylut2000.server.model.dto.TodoRequestDTO;
import com.dylut2000.server.service.TodoService;
import com.dylut2000.server.system.Result;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    // GET ALL TODOS (ADMIN_ROLE)

    @GetMapping
    public ResponseEntity<Result> getAllTodos() {
        List<TodoDTO> todos = todoService.getAllTodos();

        Result result = new Result(HttpStatus.ACCEPTED.value(), true, "Success", todos);
        return ResponseEntity.ok(result);
    }


    // GET ALL TODOS BY USER_ID

    @GetMapping("/{userId}")
    public ResponseEntity<Result> getAllTodosByUserId(@PathVariable String userId) {
        List<TodoDTO> todos = todoService.getAllTodosByUserId(userId);
        Result result = new Result(HttpStatus.ACCEPTED.value(), true, "Success", todos);
        return ResponseEntity.ok(result);
    }


    // ADD NEW TODO

    @PostMapping
    public String addNewTodo(@RequestBody TodoRequestDTO todoRequestDTO) {
        return "added";
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
