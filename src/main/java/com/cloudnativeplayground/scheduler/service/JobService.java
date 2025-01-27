package com.cloudnativeplayground.scheduler.service;

import com.cloudnativeplayground.scheduler.model.Job;
import com.cloudnativeplayground.scheduler.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepositoryRepository;

    // Create or update a job
    public Job saveJob(Job job) {
        return jobRepositoryRepository.save(job);
    }

    // Find a job by its ID
    public Optional<Job> getJobById(Long jobId) {
        return jobRepositoryRepository.findById(jobId);
    }

    // Find a job by its name
    public Optional<Job> getJobByName(String name) {
        return jobRepositoryRepository.findByName(name);
    }

    // Find all enabled jobs
    public List<Job> getEnabledJobs() {
        return jobRepositoryRepository.findByEnabled(true);
    }

    // Find jobs by priority
    public List<Job> getJobsByPriority(int priority) {
        return jobRepositoryRepository.findByPriorityOrderByPriorityDesc(priority);
    }

    // Delete a job by its ID
    public void deleteJob(Long jobId) {
        jobRepositoryRepository.deleteById(jobId);
    }
}
