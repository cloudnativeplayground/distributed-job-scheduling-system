package com.cloudnativeplayground.scheduler.repository;

import com.cloudnativeplayground.scheduler.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("jobRepositoryRepository")
public interface JobRepository extends JpaRepository<Job, Long> {

    // Find a job by its name
    Optional<Job> findByName(String name);

    // Find jobs by their enabled status
    List<Job> findByEnabled(boolean enabled);

    // Find jobs by priority, sorted in descending order
    List<Job> findByPriorityOrderByPriorityDesc(int priority);
}
