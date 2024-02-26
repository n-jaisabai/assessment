package com.kbtg.bootcamp.posttest.exception;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ApiErrorResponseTest {

    @Test
    void whenCalltoString_thenResultShouldBeCorrectString() {
        ApiErrorResponse apiErrorResponse = new ApiErrorResponse(LocalDateTime.parse("2024-02-26T08:30:00"), 404, "Not Found", "Lottery not found", "/lottery/1");

        String expected = "ApiErrorResponse(timestamp=" + LocalDateTime.parse("2024-02-26T08:30:00") + ", status=404, error=Not Found, message=Lottery not found, path=/lottery/1)";
        assertEquals(expected, apiErrorResponse.toString());
    }
}