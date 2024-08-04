package ru.example.mapper;

import com.google.protobuf.Timestamp;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class TimestampMapper {

    public static Timestamp map(LocalDateTime value) {
        if (value != null) {
            return Timestamp.newBuilder()
                    .setSeconds(value.toInstant(ZoneOffset.UTC).getEpochSecond())
                    .setNanos(value.toInstant(ZoneOffset.UTC).getNano())
                    .build();
        }
        return Timestamp.newBuilder().build();
    }

    public static LocalDateTime mapLDT(Timestamp value) {
        if (value != null) {
            return Instant
                    .ofEpochSecond(value.getSeconds(), value.getNanos())
                    .atOffset(ZoneOffset.UTC)
                    .toLocalDateTime();
        }
        return null;
    }

    public static Timestamp map(LocalDate value) {
        if (value != null) {
            return Timestamp.newBuilder()
                    .setSeconds(value.atStartOfDay().toInstant(ZoneOffset.UTC).getEpochSecond())
                    .setNanos(value.atStartOfDay().toInstant(ZoneOffset.UTC).getNano())
                    .build();
        }
        return Timestamp.newBuilder().build();
    }

    public static LocalDate map(Timestamp value) {
        if (value != null) {
            return Instant
                    .ofEpochSecond(value.getSeconds(), value.getNanos())
                    .atOffset(ZoneOffset.UTC)
                    .toLocalDate();
        }
        return null;
    }
}
