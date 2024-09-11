package br.com.fullstack.postit.dtos;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ErrorResponse {

    private String exceptionClass;

    private String code;
    private String message;

    private List<String> fields;

}
