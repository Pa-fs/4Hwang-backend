package com.green.sahwang.config;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtils {

    private static final DateTimeFormatter DEFAULT_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private DateTimeUtils() {}

    public static String format(LocalDateTime dateTime) {
        return dateTime.format(DEFAULT_FORMATTER);
    }
    public static LocalDateTime parse(String dateTimeString) {
        return LocalDateTime.parse(dateTimeString, DEFAULT_FORMATTER);
    }
}
