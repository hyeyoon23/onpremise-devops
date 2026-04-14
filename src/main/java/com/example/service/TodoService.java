package com.example.service;

import com.example.domain.Todo;
import com.example.dto.TodoRequestDto;
import com.example.dto.TodoResponseDto;
import com.example.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public TodoResponseDto create(TodoRequestDto dto) {
        Todo todo = new Todo(dto.getTitle(), dto.getContent(), false);
        Todo savedTodo = todoRepository.save(todo);
        return TodoResponseDto.from(savedTodo);
    }

    public List<TodoResponseDto> findAll() {
        return todoRepository.findAll()
                .stream()
                .map(TodoResponseDto::from)
                .collect(Collectors.toList());
    }

    public TodoResponseDto findById(Long id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Todo not found"));
        return TodoResponseDto.from(todo);
    }

    public TodoResponseDto update(Long id, TodoRequestDto dto) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Todo not found"));

        todo.setTitle(dto.getTitle());
        todo.setContent(dto.getContent());

        Todo updatedTodo = todoRepository.save(todo);
        return TodoResponseDto.from(updatedTodo);
    }

    public void delete(Long id) {
        todoRepository.deleteById(id);
    }

    public TodoResponseDto toggle(Long id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Todo not found"));

        todo.setCompleted(!todo.isCompleted());

        Todo updatedTodo = todoRepository.save(todo);
        return TodoResponseDto.from(updatedTodo);
    }
}