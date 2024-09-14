package br.com.fullstack.postit.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@Schema(description = "Error response")
public class ErrorResponse {

    @Schema(description = "Exception class", example = "Exception")
    private String exceptionClass;

    @Schema(description = "Error code", example = "404")
    private String code;

    @Schema(description = "Error message", example = "Entity not found")
    private String message;

    @Schema(
            description = "Fields",
            type = "array",
            example = "[\"Title is required\", \"Invalid priority value\"]"
    )
    private List<String> fields;

}
