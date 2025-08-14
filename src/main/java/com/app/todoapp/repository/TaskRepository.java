package com.app.todoapp.repository;

import com.app.todoapp.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task,Long> {

    List<Task> findAllByOrderByIdAsc();
}
