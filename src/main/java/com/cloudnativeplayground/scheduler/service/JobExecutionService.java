package com.cloudnativeplayground.scheduler.service;

import com.cloudnativeplayground.scheduler.model.JobExecution;
import com.cloudnativeplayground.scheduler.repository.JobExecutionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobExecutionService {

    @Autowired
    private JobExecutionRepository jobExecutionRepository;

    // Create or update a job execution
    public JobExecution saveJobExecution(JobExecution jobExecution) {
        return jobExecutionRepository.save(jobExecution);
    }

    // Find job executions by job ID
    public List<JobExecution> getJobExecutionsByJobId(Long jobId) {
        return jobExecutionRepository.findByJobId(jobId);
    }

    // Find the most recent execution of a job by job ID
    public Optional<JobExecution> getMostRecentJobExecution(Long jobId) {
        return jobExecutionRepository.findTopByJobIdOrderByStartTimeDesc(jobId);
    }

    // Find job executions by status
    public List<JobExecution> getJobExecutionsByStatus(String status) {
        return jobExecutionRepository.findByStatus(status);
    }

    // Find job executions with a retry count greater than the specified value
    public List<JobExecution> getJobExecutionsByRetryCountGreaterThan(int retryCount) {
        return jobExecutionRepository.findByRetryCountGreaterThan(retryCount);
    }

    // Delete a job execution by its ID
    public void deleteJobExecution(Long jobExecutionId) {
        jobExecutionRepository.deleteById(jobExecutionId);
    }
}
