package br.com.fullstack.postit.dtos;

import br.com.fullstack.postit.enums.Priority;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Schema(description = "Abstract reminder (used to inherit)")
public abstract class ReminderAbstract {
    @Schema(
            description = "Title",
            example = "Reminder title"
    )
    private String title;

    @Schema(
            description = "Description",
            example = "Reminder description"
    )
    private String description;

    @Schema(description = "Remind at",
            pattern = "yyyy-MM-dd'T'HH:mm:ss",
            example = "2024-01-01T08:00:00",
            type = "string"
    )
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime remindAt;


    @Schema(
            description = "Priority",
            example = "MEDIUM"
    )
    private Priority priority;
}
