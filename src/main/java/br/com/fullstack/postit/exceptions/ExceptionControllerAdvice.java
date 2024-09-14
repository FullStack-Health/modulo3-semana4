package br.com.fullstack.postit.exceptions;

import br.com.fullstack.postit.dtos.ErrorResponse;
import br.com.fullstack.postit.exceptions.notfound.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handle(Exception e) {
        return ResponseEntity.status(500).body(
                ErrorResponse.builder()
                        .exceptionClass(e.getClass().getSimpleName())
                        .code("500")
                        .message(e.getLocalizedMessage())
                        .build()
        );
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse> handle(HttpMessageNotReadableException e) {
        return ResponseEntity.status(400).body(
                ErrorResponse.builder()
                        .exceptionClass(e.getClass().getSimpleName())
                        .code("400")
                        .message(e.getLocalizedMessage())
                        .build()
        );
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> handle(NotFoundException e) {
        return ResponseEntity.status(404).body(
                ErrorResponse.builder()
                        .exceptionClass(e.getClass().getSimpleName())
                        .code("404")
                        .message(e.getLocalizedMessage())
                        .build()
        );
    }

}
