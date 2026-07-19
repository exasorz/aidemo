package com.example.todo.service;

import com.example.todo.model.Todo;
import com.example.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    /**
     * 全てのToDoアイテムを取得
     */
    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    /**
     * IDでToDoアイテムを取得
     */
    public Optional<Todo> getTodoById(Long id) {
        return todoRepository.findById(id);
    }

    /**
     * ToDoアイテムを作成
     */
    public Todo createTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    /**
     * ToDoアイテムを更新
     */
    public Todo updateTodo(Long id, Todo todoDetails) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ToDoが見つかりません ID: " + id));

        todo.setTitle(todoDetails.getTitle());
        todo.setDescription(todoDetails.getDescription());
        todo.setDueDate(todoDetails.getDueDate());
        todo.setCompleted(todoDetails.getCompleted());

        return todoRepository.save(todo);
    }

    /**
     * ToDoアイテムを削除
     */
    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }

    /**
     * ToDoアイテムのステータスを更新
     */
    public Todo updateTodoStatus(Long id, Boolean isCompleted) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ToDoが見つかりません ID: " + id));

        todo.setCompleted(isCompleted);
        return todoRepository.save(todo);
    }
}