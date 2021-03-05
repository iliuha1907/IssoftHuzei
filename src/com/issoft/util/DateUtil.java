package com.issoft.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtil {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-M-dd'T'HH:mm[:ss]");

    public static LocalDate getDate(final String data) {
        return LocalDate.parse(data, FORMATTER);
    }
}
