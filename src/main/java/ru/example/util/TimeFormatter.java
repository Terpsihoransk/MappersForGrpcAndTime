package ru.example.util;

import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.time.DurationFormatUtils;
import org.mapstruct.Named;

import java.sql.Time;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

@UtilityClass
public class TimeFormatter {

    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");

    @Named("formatSeconds")
    public String formatSeconds(Integer seconds) {
        if (seconds != null) {
            long durationInMillis = seconds * 1000L;
            long hours = TimeUnit.MILLISECONDS.toHours(durationInMillis);

            if (hours >= 1) {
                return DurationFormatUtils.formatDuration(durationInMillis, "HH:mm:ss");
            } else {
                return DurationFormatUtils.formatDuration(durationInMillis, "mm:ss");
            }
        }
        return null;
    }

    @Named("stringToTime")
    public Time stringToTime(String timeString) {
        if (timeString == null) {
            return null;
        }
        LocalTime localTime = LocalTime.parse(timeString, TIME_FORMATTER);
        return Time.valueOf(localTime);
    }

    @Named("timeToString")
    public String timeToString(Time time) {
        if (time == null) {
            return null;
        }
        return time.toLocalTime().format(TIME_FORMATTER);
    }
}
