package com.example.TaskManagerWebApp.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TaskManagerWebApp.Model.Task;
import com.example.TaskManagerWebApp.Repository.TaskRepository;

@Service //It is an business logic for service layer components
public class TaskService {
    
    @Autowired // it is automatically inject the dependencies , it used to applied Constructor,field,methods, 
    private TaskRepository taskRepository;
    
    // when Enter the Data  ( Example id=1 ,Title=java, status = pending goto mapping to fetch all list ) 
    public List<Task> getAllTasks() {   
        return taskRepository.findAll();
    }
    
    public Optional<Task> getTaskById(Long id) { // iam not enter the any data it shows me the  no id DB
        return taskRepository.findById(id);
    }
    
    //IAM using unchecked exception because it checks the runtime and after Executing it will be seen result ,
    //Create task means when we enter the data in postman when you are missing any task it shows the IllegalArgumentException 
    public Task createTask(Task task) {
        if (task.getTitle() == null || task.getTitle().trim().isEmpty()) {
            throw new IllegalArgumentException("Task title cannot be empty");
        }
        if (task.getDescription() == null || task.getDescription().trim().isEmpty()) {
            throw new IllegalArgumentException("Task description cannot be empty");
        }
        if (task.getDueDate() == null) {
            throw new IllegalArgumentException("Due date cannot be null");
        }
        if (task.getStatus() == null) {
            task.setStatus(Task.TaskStatus.PENDING);
        }
        
        return taskRepository.save(task);
    }
     //enter IDs enter two time if show the Throw error
    public Task updateTask(Long id, Task taskDetails) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found with id: " + id));
        
        if (taskDetails.getTitle() != null && !taskDetails.getTitle().trim().isEmpty()) {
            task.setTitle(taskDetails.getTitle());
        }
        if (taskDetails.getDescription() != null && !taskDetails.getDescription().trim().isEmpty()) {
            task.setDescription(taskDetails.getDescription());
        }
        if (taskDetails.getDueDate() != null) {
            task.setDueDate(taskDetails.getDueDate());
        }
        if (taskDetails.getStatus() != null) {
            task.setStatus(taskDetails.getStatus());
        }
        
        return taskRepository.save(task);
    }
    //delete the task Incase no task it shows the task not found with id
    public void deleteTask(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found with id: " + id));
        taskRepository.delete(task);
    }
}
