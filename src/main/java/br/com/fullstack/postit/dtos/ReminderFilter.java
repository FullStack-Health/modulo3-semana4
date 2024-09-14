package br.com.fullstack.postit.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Schema(description = "Filter parameters")
public class ReminderFilter {
    @Schema(
            description = "Initial date/time",
            example = "2024-01-01T08:00:00",
            type = "date-time"
    )
    private LocalDateTime dateTimeInitial;

    @Schema(
            description = "Final date/time (if null, then last time of 'dateTimeInitial')",
            example = "2024-01-01T23:59:59",
            type = "date-time"
    )
    private LocalDateTime dateTimeFinal;
}
