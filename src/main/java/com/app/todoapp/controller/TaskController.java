package com.app.todoapp.controller;

import com.app.todoapp.model.Task;
import com.app.todoapp.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;


@Controller
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public String getTasks(Model model){
        List<Task> tasks = taskService.getAllTask();
        model.addAttribute("tasks",tasks);
        return "tasks";
    }

    @PostMapping
    public String createTask(@RequestParam String title,Model model){
        taskService.createTask(title);

        model.addAttribute("tasks", taskService.getAllTaskOrdered());
        return "tasks";
    }

    @GetMapping("/{id}/delete")
    public String deleteTask(@PathVariable Long id,Model model){
        taskService.delete(id);
        model.addAttribute("tasks", taskService.getAllTaskOrdered());
        return "tasks";
    }

    @GetMapping("/{id}/toggle")
    public String toggleTask(@PathVariable Long id, Model model) {
        taskService.toggle(id);


        model.addAttribute("tasks", taskService.getAllTaskOrdered());

        return "tasks";
    }
}
