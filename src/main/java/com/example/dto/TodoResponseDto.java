package com.example.dto;

import com.example.domain.Todo;

public class TodoResponseDto {

    private Long id;
    private String title;
    private String content;
    private boolean completed;

    public TodoResponseDto(Long id, String title, String content, boolean completed) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.completed = completed;
    }

    public static TodoResponseDto from(Todo todo) {
        return new TodoResponseDto(
                todo.getId(),
                todo.getTitle(),
                todo.getContent(),
                todo.isCompleted()
        );
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public boolean isCompleted() {
        return completed;
    }
}