package com.omargroup.todo_backend.repository;

import com.omargroup.todo_backend.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo,Long> {

    List<Todo> findByUsername(String username);

}
