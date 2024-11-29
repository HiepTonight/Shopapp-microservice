package com.hieptran.common.util;

import lombok.experimental.UtilityClass;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@UtilityClass
public class DateUtil {
    public final String RESPONSE_DATE_FORMAT = "dd-MM-yyyy";
    public final String RESPONSE_TIME_FORMAT = "ss:mm:HH";

    public LocalDate convertDateResponseToLocalDate(String dateStr, String pattern) {
        if (!Utility.isNullOrEmpty(dateStr)) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);

            return LocalDate.parse(dateStr, formatter);
        }

        return null;
    }

    public LocalTime convertDateResponseToLocalTime(String timeStr, String pattern) {
        if (!Utility.isNullOrEmpty(timeStr)) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);

            return LocalTime.parse(timeStr, formatter);
        }

        return null;
    }
}
