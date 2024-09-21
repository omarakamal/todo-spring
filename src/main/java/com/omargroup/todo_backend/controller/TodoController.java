package com.omargroup.todo_backend.controller;

import com.omargroup.todo_backend.exceptions.ResourceNotFoundException;
import com.omargroup.todo_backend.model.Todo;
import com.omargroup.todo_backend.service.TodoService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/v1/todos")
public class TodoController {

    private final TodoService todoService;

//    @Value("${omar.something}")
//    private String message;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Todo> getTodoById(@PathVariable Long id) {
//        System.out.println(message);
        Todo todo = todoService.findById(id);  // Let the exception propagate
        return ResponseEntity.ok(todo);
    }


    @GetMapping
    public List<Todo> findAllTodos(){
        return todoService.getAllTodos();
    }




    @PostMapping
    public ResponseEntity<Todo> addNewTodo(@RequestBody @Valid Todo todo){
        Todo createdTodo = todoService.addTodo(todo);

        return new ResponseEntity<>(createdTodo, HttpStatus.CREATED);
    }

    @GetMapping("/by-username/{username}")
    public ResponseEntity<List<Todo>> getTodoByUsername(@PathVariable String username){
        List<Todo> todos = todoService.findByUsername(username);

        return ResponseEntity.ok(todos);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Todo> updateTodo(@RequestBody Todo todo,@PathVariable @Valid Long id){

        Todo updatedTodo = todoService.updateTodo(id,todo);

        return ResponseEntity.ok(updatedTodo);
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable Long id){
        todoService.deleteById(id);
        return ResponseEntity.noContent().build();

    }



}
