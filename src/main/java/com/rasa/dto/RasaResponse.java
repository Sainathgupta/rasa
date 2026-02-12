package com.rasa.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.time.LocalDateTime;

// This ensures that if 'data' is null (like in an error), it's hidden from the JSON
@JsonInclude(JsonInclude.Include.NON_NULL)
public record RasaResponse<T>(
        boolean success,
        String message,
        LocalDateTime timestamp,
        T data
) {
    // Helper for Success responses
    public static <T> RasaResponse<T> ok(T data, String message) {
        return new RasaResponse<>(true, message, LocalDateTime.now(), data);
    }

    // Helper for Error responses
    public static <T> RasaResponse<T> fail(String message) {
        return new RasaResponse<>(false, message, LocalDateTime.now(), null);
    }
}
