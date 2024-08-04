package ru.example.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class GetDataDto {
    private LocalDate date;
    private int intCount;
    private String test;
}
