package com.cloudnativeplayground.scheduler.controller;

import com.cloudnativeplayground.scheduler.model.Task;
import com.cloudnativeplayground.scheduler.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    // Create or update a task
    @PostMapping
    public ResponseEntity<Task> createOrUpdateTask(@RequestBody Task task) {
        Task savedTask = taskService.saveTask(task);
        return new ResponseEntity<>(savedTask, HttpStatus.CREATED);
    }

    // Get tasks by job ID
    @GetMapping("/job/{jobId}")
    public ResponseEntity<List<Task>> getTasksByJobId(@PathVariable Long jobId) {
        List<Task> tasks = taskService.getTasksByJobId(jobId);
        return ResponseEntity.ok(tasks);
    }

    // Get tasks by job ID and completion status
    @GetMapping("/job/{jobId}/completed/{completed}")
    public ResponseEntity<List<Task>> getTasksByJobIdAndCompletionStatus(@PathVariable Long jobId, @PathVariable boolean completed) {
        List<Task> tasks = taskService.getTasksByJobIdAndCompletionStatus(jobId, completed);
        return ResponseEntity.ok(tasks);
    }

    // Get tasks by task name and job ID
    @GetMapping("/name/{taskName}/job/{jobId}")
    public ResponseEntity<List<Task>> getTasksByTaskNameAndJobId(@PathVariable String taskName, @PathVariable Long jobId) {
        List<Task> tasks = taskService.getTasksByTaskNameAndJobId(taskName, jobId);
        return ResponseEntity.ok(tasks);
    }

    // Delete a task by its ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
}
