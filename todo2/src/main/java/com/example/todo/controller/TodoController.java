package com.example.todo.controller;

import com.example.todo.model.Todo;
import com.example.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    /**
     * 一覧画面を表示
     */
    @GetMapping
    public String listTodos(Model model) {
        List<Todo> todos = todoService.getAllTodos();
        model.addAttribute("todos", todos);
        return "index";
    }

    /**
     * 新規ToDoのフォームを表示
     */
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("todo", new Todo());
        return "create";
    }

    /**
     * 新規ToDoを作成
     */
    @PostMapping("/create")
    public String createTodo(@ModelAttribute Todo todo) {
        // 期限が未来の日付の場合、今日の日付を設定
        if (todo.getDueDate() != null && todo.getDueDate().isBefore(LocalDate.now())) {
            todo.setDueDate(null);
        }

        todoService.createTodo(todo);
        return "redirect:/todos";
    }

    /**
     * ToDoの編集フォームを表示
     */
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Optional<Todo> todo = todoService.getTodoById(id);
        if (todo.isPresent()) {
            model.addAttribute("todo", todo.get());
            return "edit";
        } else {
            return "redirect:/todos";
        }
    }

    /**
     * ToDoを更新
     */
    @PostMapping("/update/{id}")
    public String updateTodo(@PathVariable Long id, @ModelAttribute Todo todoDetails) {
        todoService.updateTodo(id, todoDetails);
        return "redirect:/todos";
    }

    /**
     * ToDoを削除
     */
    @PostMapping("/delete/{id}")
    public String deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);
        return "redirect:/todos";
    }

    /**
     * ToDoのステータスを更新
     */
    @PostMapping("/update-status/{id}")
    public String updateTodoStatus(@PathVariable Long id, @RequestParam Boolean completed) {
        todoService.updateTodoStatus(id, completed);
        return "redirect:/todos";
    }
}