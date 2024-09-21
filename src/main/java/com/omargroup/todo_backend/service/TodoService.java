package com.omargroup.todo_backend.service;

import com.omargroup.todo_backend.exceptions.ResourceNotFoundException;
import com.omargroup.todo_backend.model.Todo;
import com.omargroup.todo_backend.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }


    public List<Todo> findByUsername(String username){

        return todoRepository.findByUsername(username);
    }

    public Todo addTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public void deleteById(Long id) {
        if (todoRepository.existsById(id)) {
            todoRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Todo not found with id: " + id);
        }
    }

    public Todo findById(Long id) {
       return todoRepository.findById(id).orElseThrow(()->
               new ResourceNotFoundException("Todo with this Id does not exist"));
    }

    public Todo updateTodo(Long id, Todo updatedTodo) {
        return todoRepository.findById(id)
                .map(todo -> {
                    todo.setDescription(updatedTodo.getDescription());
                    todo.setDone(updatedTodo.isDone());
                    todo.setTargetDate(updatedTodo.getTargetDate());
                    return todoRepository.save(todo);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Todo not found with id: " + id));
    }

    public List<Todo> getAllTodos(){
        return todoRepository.findAll();
    }
}
