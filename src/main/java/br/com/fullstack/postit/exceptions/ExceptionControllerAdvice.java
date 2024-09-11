package br.com.fullstack.postit.exceptions;

import br.com.fullstack.postit.dtos.ErrorResponse;
import br.com.fullstack.postit.exceptions.notfound.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

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
