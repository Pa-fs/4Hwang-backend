package com.green.sahwang.config;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtils {

    private static final DateTimeFormatter DEFAULT_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static final DateTimeFormatter FORMATTER_WITHOUT_SECOND = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    private static final DateTimeFormatter ORDERNUMBER_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
    private DateTimeUtils() {}

    public static String format(LocalDateTime dateTime) {
        return dateTime.format(DEFAULT_FORMATTER);
    }

    public static String formatWithoutSecond(LocalDateTime dateTime) {
        return dateTime.format(FORMATTER_WITHOUT_SECOND);
    }

    public static String formatOrderNumber(LocalDateTime dateTime) {
        return dateTime.format(ORDERNUMBER_FORMATTER);
    }

    public static LocalDateTime parse(String dateTimeString) {
        return LocalDateTime.parse(dateTimeString, DEFAULT_FORMATTER);
    }
}
