package br.com.fullstack.postit.dtos;

import br.com.fullstack.postit.enums.Priority;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public abstract class ReminderAbstract {
    private String title;
    private String description;
    private LocalDateTime remindAt;
    private Priority priority;
}
