package com.kbtg.bootcamp.posttest.exception;

import org.junit.jupiter.api.Test;
import org.springframework.core.MethodParameter;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.context.request.WebRequest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class ControllerExceptionHandlerTest {

    @Test
    void whenMethodArgumentNotValidExceptionThrown_thenResponseShouldBeBadRequest() {
        ControllerExceptionHandler controllerExceptionHandler = new ControllerExceptionHandler();
        MethodArgumentNotValidException methodArgumentNotValidException = new MethodArgumentNotValidException(mock(MethodParameter.class), mock(BindingResult.class));

        var response = controllerExceptionHandler.handleBadRequestException(methodArgumentNotValidException, mock(WebRequest.class));

        assertEquals(400, response.getStatus());
    }

    @Test
    void whenIllegalArgumentExceptionThrown_thenResponseShouldBeBadRequest() {
        ControllerExceptionHandler controllerExceptionHandler = new ControllerExceptionHandler();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Illegal argument exception");

        var response = controllerExceptionHandler.handleBadRequestException(illegalArgumentException, mock(WebRequest.class));

        assertEquals(400, response.getStatus());
        assertEquals("Illegal argument exception", response.getMessage());
    }

    @Test
    void whenNotFoundExceptionThrown_thenResponseShouldBeNotFound() {
        ControllerExceptionHandler controllerExceptionHandler = new ControllerExceptionHandler();
        NotFoundException notFoundException = new NotFoundException("Not found exception");

        var response = controllerExceptionHandler.handleNotFoundRequestException(notFoundException, mock(WebRequest.class));

        assertEquals(404, response.getStatus());
        assertEquals("Not found exception", response.getMessage());
    }

    @Test
    void whenInternalServerExceptionThrown_thenResponseShouldBeInternalServerError() {
        ControllerExceptionHandler controllerExceptionHandler = new ControllerExceptionHandler();
        InternalServerException internalServerException = new InternalServerException("Internal server exception");

        var response = controllerExceptionHandler.handleInternalServerException(internalServerException, mock(WebRequest.class));

        assertEquals(500, response.getStatus());
        assertEquals("Internal server exception", response.getMessage());
    }
}
