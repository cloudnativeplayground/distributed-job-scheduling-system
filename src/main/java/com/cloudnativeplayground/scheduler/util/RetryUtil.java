package com.cloudnativeplayground.scheduler.util;

import java.util.function.Supplier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RetryUtil {

    private static final Logger logger = LoggerFactory.getLogger(RetryUtil.class);

    /**
     * Executes a task and retries in case of failure.
     * @param task The task to execute.
     * @param retries The number of retry attempts.
     * @param delayMillis Delay between retries in milliseconds.
     * @param <T> The type of result returned by the task.
     * @return The result of the task if successful, otherwise throws an exception.
     */
    public static <T> T executeWithRetry(Supplier<T> task, int retries, long delayMillis) {
        int attempt = 0;
        while (attempt <= retries) {
            try {
                return task.get();
            } catch (Exception e) {
                attempt++;
                logger.warn("Attempt {} failed. Retrying in {} ms...", attempt, delayMillis, e);
                if (attempt > retries) {
                    logger.error("Max retry attempts reached. Task failed.");
                    throw e;
                }
                try {
                    Thread.sleep(delayMillis);
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException("Retry operation interrupted", ie);
                }
            }
        }
        throw new IllegalStateException("Should never reach here");
    }
}
