package com.caruta.kn.exception;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.caruta.kn.enums.MessageType;
import com.caruta.kn.model.Message;
import com.caruta.kn.model.Response;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Response<Void>> handleConstraintViolationException(ConstraintViolationException ex) {
        Response<Void> response = new Response<>();
        List<Message> messages = new ArrayList<Message>();

        Set<ConstraintViolation<?>> violations = ex.getConstraintViolations();
        violations.forEach(violation -> {
            Message message = new Message(MessageType.WARNING, "W_0006", violation.getMessageTemplate());
            messages.add(message);
        });

        response.setMessages(messages);
        return ResponseEntity.badRequest().body(response);
    }
}