package com.cloudnativeplayground.scheduler.repository;

import com.cloudnativeplayground.scheduler.model.JobExecution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JobExecutionRepository extends JpaRepository<JobExecution, Long> {

    // Find job executions by job ID
    List<JobExecution> findByJobId(Long jobId);

    // Find the most recent execution of a job
    Optional<JobExecution> findTopByJobIdOrderByStartTimeDesc(Long jobId);

    // Find job executions by status
    List<JobExecution> findByStatus(String status);

    // Find job executions by retry count
    List<JobExecution> findByRetryCountGreaterThan(int retryCount);
}
