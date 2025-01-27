package com.cloudnativeplayground.scheduler.repository;

import com.cloudnativeplayground.scheduler.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    // Find tasks by job ID
    List<Task> findByJobId(Long jobId);

    // Find tasks by job and completion status
    List<Task> findByJobIdAndCompleted(Long jobId, boolean completed);

    // Find tasks by name and job ID
    List<Task> findByTaskNameAndJobId(String taskName, Long jobId);
}
