package com.cloudnativeplayground.scheduler.controller;

import com.cloudnativeplayground.scheduler.model.JobExecution;
import com.cloudnativeplayground.scheduler.service.JobExecutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/jobexecutions")
public class JobExecutionController {

    @Autowired
    private JobExecutionService jobExecutionService;

    // Create or update a job execution
    @PostMapping
    public ResponseEntity<JobExecution> createOrUpdateJobExecution(@RequestBody JobExecution jobExecution) {
        JobExecution savedExecution = jobExecutionService.saveJobExecution(jobExecution);
        return new ResponseEntity<>(savedExecution, HttpStatus.CREATED);
    }

    // Get job executions by job ID
    @GetMapping("/job/{jobId}")
    public ResponseEntity<List<JobExecution>> getJobExecutionsByJobId(@PathVariable Long jobId) {
        List<JobExecution> executions = jobExecutionService.getJobExecutionsByJobId(jobId);
        return ResponseEntity.ok(executions);
    }

    // Get the most recent execution of a job
    @GetMapping("/job/{jobId}/latest")
    public ResponseEntity<JobExecution> getMostRecentJobExecution(@PathVariable Long jobId) {
        Optional<JobExecution> execution = jobExecutionService.getMostRecentJobExecution(jobId);
        return execution.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get job executions by status
    @GetMapping("/status/{status}")
    public ResponseEntity<List<JobExecution>> getJobExecutionsByStatus(@PathVariable String status) {
        List<JobExecution> executions = jobExecutionService.getJobExecutionsByStatus(status);
        return ResponseEntity.ok(executions);
    }

    // Get job executions with retry count greater than a specified number
    @GetMapping("/retry/{retryCount}")
    public ResponseEntity<List<JobExecution>> getJobExecutionsByRetryCountGreaterThan(@PathVariable int retryCount) {
        List<JobExecution> executions = jobExecutionService.getJobExecutionsByRetryCountGreaterThan(retryCount);
        return ResponseEntity.ok(executions);
    }

    // Delete a job execution by its ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJobExecution(@PathVariable Long id) {
        jobExecutionService.deleteJobExecution(id);
        return ResponseEntity.noContent().build();
    }
}
