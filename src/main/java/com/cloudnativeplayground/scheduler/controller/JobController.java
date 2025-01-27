package com.cloudnativeplayground.scheduler.controller;

import com.cloudnativeplayground.scheduler.model.Job;
import com.cloudnativeplayground.scheduler.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

    @Autowired
    private JobService jobService;

    // Create or update a job
    @PostMapping
    public ResponseEntity<Job> createOrUpdateJob(@RequestBody Job job) {
        Job savedJob = jobService.saveJob(job);
        return new ResponseEntity<>(savedJob, HttpStatus.CREATED);
    }

    // Get a job by its ID
    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id) {
        Optional<Job> job = jobService.getJobById(id);
        return job.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get a job by its name
    @GetMapping("/name/{name}")
    public ResponseEntity<Job> getJobByName(@PathVariable String name) {
        Optional<Job> job = jobService.getJobByName(name);
        return job.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get all enabled jobs
    @GetMapping("/enabled")
    public ResponseEntity<List<Job>> getEnabledJobs() {
        List<Job> jobs = jobService.getEnabledJobs();
        return ResponseEntity.ok(jobs);
    }

    // Get jobs by priority
    @GetMapping("/priority/{priority}")
    public ResponseEntity<List<Job>> getJobsByPriority(@PathVariable int priority) {
        List<Job> jobs = jobService.getJobsByPriority(priority);
        return ResponseEntity.ok(jobs);
    }

    // Delete a job by its ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJob(@PathVariable Long id) {
        jobService.deleteJob(id);
        return ResponseEntity.noContent().build();
    }
}
