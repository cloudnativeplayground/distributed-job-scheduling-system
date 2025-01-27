package com.cloudnativeplayground.scheduler.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TaskLogger {

    private static final Logger logger = LoggerFactory.getLogger(TaskLogger.class);

    /**
     * Logs the status of a job/task.
     * @param taskId The unique identifier for the task.
     * @param message The log message.
     */
    public static void logTaskStatus(String taskId, String message) {
        logger.info("Task ID: {} - {}", taskId, message);
    }

    /**
     * Logs an error during task execution.
     * @param taskId The unique identifier for the task.
     * @param message The error message.
     * @param exception The exception thrown.
     */
    public static void logTaskError(String taskId, String message, Exception exception) {
        logger.error("Task ID: {} - {}. Error: {}", taskId, message, exception.getMessage(), exception);
    }
}
