package br.com.fullstack.postit.dtos;

import br.com.fullstack.postit.entities.Reminder;
import br.com.fullstack.postit.enums.Status;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@NoArgsConstructor
public class ReminderResponse extends ReminderAbstract {

    private Long id;
    private Status status;

    public ReminderResponse(Reminder reminder) {
        BeanUtils.copyProperties(reminder, this);
    }

}
