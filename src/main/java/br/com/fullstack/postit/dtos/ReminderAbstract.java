package br.com.fullstack.postit.dtos;

import br.com.fullstack.postit.enums.Priority;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public abstract class ReminderAbstract {
    private String title;

    private String description;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime remindAt;

    private Priority priority;
}
