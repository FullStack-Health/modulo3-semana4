package br.com.fullstack.postit.dtos;

import br.com.fullstack.postit.entities.Reminder;
import br.com.fullstack.postit.enums.Status;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@NoArgsConstructor
@Schema(description = "Reminder response")
public class ReminderResponse extends ReminderAbstract {

    @Schema(description = "Id", example = "1")
    private Long id;

    @Schema(description = "Status", example = "PENDING")
    private Status status;

    public ReminderResponse(Reminder reminder) {
        BeanUtils.copyProperties(reminder, this);
    }

}
