package com.cloudnativeplayground.scheduler.util;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DateUtil {

    /**
     * Converts an Instant to a formatted date string.
     * @param instant The Instant to convert.
     * @return A string representing the formatted date.
     */
    public static String formatInstant(Instant instant) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
                .withZone(ZoneId.systemDefault());
        return formatter.format(instant);
    }

    /**
     * Converts a string representing a date to LocalDateTime.
     * @param dateStr The date string.
     * @param format The format of the date string.
     * @return LocalDateTime object representing the parsed date.
     */
    public static LocalDateTime parseDate(String dateStr, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return LocalDateTime.parse(dateStr, formatter);
    }

    /**
     * Get the current date and time as a formatted string.
     * @return The current date and time.
     */
    public static String getCurrentDateTime() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
}
