package com.cloudnativeplayground.scheduler.service;

import com.cloudnativeplayground.scheduler.model.Task;
import com.cloudnativeplayground.scheduler.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    // Create or update a task
    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    // Find tasks by job ID
    public List<Task> getTasksByJobId(Long jobId) {
        return taskRepository.findByJobId(jobId);
    }

    // Find tasks by job ID and completion status
    public List<Task> getTasksByJobIdAndCompletionStatus(Long jobId, boolean completed) {
        return taskRepository.findByJobIdAndCompleted(jobId, completed);
    }

    // Find tasks by name and job ID
    public List<Task> getTasksByTaskNameAndJobId(String taskName, Long jobId) {
        return taskRepository.findByTaskNameAndJobId(taskName, jobId);
    }

    // Delete a task by its ID
    public void deleteTask(Long taskId) {
        taskRepository.deleteById(taskId);
    }
}
