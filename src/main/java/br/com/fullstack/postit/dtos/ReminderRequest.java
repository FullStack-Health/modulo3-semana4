package br.com.fullstack.postit.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Reminder request")
public class ReminderRequest extends ReminderAbstract {
}
