package br.com.fullstack.postit.dtos;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReminderFilter {
    private LocalDateTime dateTimeInitial;
    private LocalDateTime dateTimeFinal;
}
