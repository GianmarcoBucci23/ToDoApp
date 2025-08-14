package com.app.todoapp.service;

import com.app.todoapp.model.Task;
import com.app.todoapp.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTask() {
        return taskRepository.findAll();
    }

    public List<Task> getAllTaskOrdered() {
        return taskRepository.findAllByOrderByIdAsc();
    }

    public void createTask(String title) {
        Task task = new Task();
        task.setStuff(title);
        task.setCompleted(false);
        taskRepository.save(task);
    }

    public void delete(Long id) {
        taskRepository.deleteById(id);
    }

    public void toggle(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("id non trovato"));

        task.setCompleted(!task.isCompleted());
        taskRepository.save(task);
    }
}
