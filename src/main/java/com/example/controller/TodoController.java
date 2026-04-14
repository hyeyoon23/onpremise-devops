package com.example.controller;

import com.example.dto.TodoRequestDto;
import com.example.dto.TodoResponseDto;
import com.example.service.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public TodoResponseDto create(@RequestBody TodoRequestDto dto) {
        return todoService.create(dto);
    }

    @GetMapping
    public List<TodoResponseDto> findAll() {
        return todoService.findAll();
    }

    @GetMapping("/{id}")
    public TodoResponseDto findById(@PathVariable Long id) {
        return todoService.findById(id);
    }

    @PutMapping("/{id}")
    public TodoResponseDto update(@PathVariable Long id, @RequestBody TodoRequestDto dto) {
        return todoService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        todoService.delete(id);
    }

    @PatchMapping("/{id}/toggle")
    public TodoResponseDto toggle(@PathVariable Long id) {
        return todoService.toggle(id);
    }
}