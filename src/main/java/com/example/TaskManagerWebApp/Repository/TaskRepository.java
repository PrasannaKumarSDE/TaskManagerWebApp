package com.example.TaskManagerWebApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.TaskManagerWebApp.Model.Task;

@Repository // easy access to database and store manage operations
public interface TaskRepository extends JpaRepository<Task, Long>{

}
