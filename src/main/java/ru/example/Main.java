package ru.example;

import ru.example.util.TimeFormatter;

import java.sql.Time;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Main {

    public static void main(String[] args) {

        String startTimeString = "09:00";
        int timeZone = 3;

        LocalTime startTime = parseFromString(startTimeString, timeZone);

        System.out.println("Second from String: " + startTime);

        Integer intSecond = 2024;

        String secondFromInt =  TimeFormatter.formatSeconds(intSecond);
        System.out.println("Second from int: " + secondFromInt);

        Time timeSecond = TimeFormatter.stringToTime(startTimeString);
        System.out.println("Time from String: " + timeSecond);
    }

    private static LocalTime parseFromString(String startTimeString, int timeZone) {
        LocalTime startTime = LocalTime.parse(startTimeString, DateTimeFormatter.ofPattern("HH:mm")).minusHours(timeZone);
        return startTime;
    }
}